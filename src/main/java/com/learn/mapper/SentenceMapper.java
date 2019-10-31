package com.learn.mapper;

import com.learn.model.Sentence;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceMapper {

    @Select("SELECT * FROM sentence WHERE id = #{id}")
    Sentence getSentence(int id);

    @Select("SELECT * FROM sentence, word_sentence WHERE word_sentence.word_id = #{id} AND sentence.id = word_sentence.sentence_id")
    List<Sentence> getSentencesByWordId(long id);


    @Insert("INSERT INTO sentence (`text`, mean, highlight) VALUES (#{text}, #{mean}, #{highlight})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int addSentence(Sentence sentence);


    @Insert("INSERT INTO word_sentence (sentence_id, word_id) VALUES (#{sentenceId}, #{wordId})")
    int addWordSentence(@Param("sentenceId") long sentenceId, @Param("wordId") long wordId);
}
