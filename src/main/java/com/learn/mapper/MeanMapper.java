package com.learn.mapper;

import com.learn.model.Mean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeanMapper {

    @Select("SELECT * FROM mean, mean_info, word_mean WHERE word_mean.word_id = #{id} " +
            "AND word_mean.mean_id = mean.id " +
            "AND mean.id = mean_info.id")
    @Results({
            @Result(column = "mean", property = "mean"),
            @Result(column = "speech_id", property = "speech",
                    one = @One(select = "com.learn.mapper.SpeechMapper.getSpeech"))
    })
    List<Mean> getMeansByWordId(long id);

    @Insert("INSERT INTO mean_info (mean) VALUES (#{mean})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int addMeanInfo(Mean mean);

    @Insert("INSERT INTO mean (id, speech_id) VALUES (${meanId}, #{speechId})")
    int addMean(@Param("meanId") long meanId, @Param("speechId") int speechId);

    @Insert("INSERT INTO word_mean (mean_id, word_id) VALUES (#{meanId}, #{wordId})")
    int addWordMean(@Param("meanId") long meanId, @Param("wordId") long wordId);
}
