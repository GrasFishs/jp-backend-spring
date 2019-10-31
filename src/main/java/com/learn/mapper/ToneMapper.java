package com.learn.mapper;

import com.learn.model.Tone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToneMapper {

    @Select("SELECT * FROM tone WHERE id = #{id}")
    Tone getTone(int id);

    @Select("SELECT * FROM tone, notation_tone_relation WHERE notation_id = #{id} AND tone.id = notation_tone_relation.tone_id")
    List<Tone> getTonesByNotationId(long id);

    @Insert("INSERT INTO tone (`index`, type) VALUES (#{index}, #{type})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int addTone(Tone tone);
}
