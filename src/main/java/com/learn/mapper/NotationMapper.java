package com.learn.mapper;

import com.learn.model.Notation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface NotationMapper {

    @Select("SELECT * FROM notation WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "text", property = "text"),
            @Result(column = "id", property = "tones", many = @Many(select = "com.learn.mapper.ToneMapper.getTonesByNotationId"))
    })
    Notation getNotation(long id);


    @Insert("INSERT INTO notation (text) VALUES (#{text})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    int addNotation(Notation notation);


    @Insert("INSERT INTO notation_tone_relation (notation_id, tone_id) VALUES (#{notationId}, #{toneId})")
    int addNotationTone(@Param("notationId") long notationId, @Param("toneId") long toneId);
}
