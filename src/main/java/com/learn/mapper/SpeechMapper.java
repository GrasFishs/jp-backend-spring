package com.learn.mapper;

import com.learn.model.Speech;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface SpeechMapper {

    @Select("SELECT * FROM speech WHERE id = #{id}")
    Speech getSpeech(int id);

    @Insert("INSERT INTO speech (name) VALUES (#{name})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    int addSpeech(Speech speech);
}
