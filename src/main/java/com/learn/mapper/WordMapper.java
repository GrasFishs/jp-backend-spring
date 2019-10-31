package com.learn.mapper;

import com.learn.model.Notation;
import com.learn.model.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * "SELECT word_info.id id, word_info.text text FROM word, word_info WHERE word.id = #{id} AND " +
 * "word_info.id = #{id} AND " +
 * "word_info.id = word.id"
 */

@Repository
public interface WordMapper {

    @Select("SELECT text FROM word_info WHERE id = #{id}")
    String getWordText(long id);


    @Select("SELECT * FROM word, word_info WHERE word.id = ${id} AND word.id = word_info.id")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "notation_id", property = "notation",
                    one = @One(select = "com.learn.mapper.NotationMapper.getNotation")),
            @Result(column = "id", property = "means",
                    many = @Many(select = "com.learn.mapper.MeanMapper.getMeansByWordId")),
            @Result(column = "id", property = "sentences",
                    many = @Many(select = "com.learn.mapper.SentenceMapper.getSentencesByWordId")
            )
    })
    Word getWord(long id);

    @Insert("INSERT INTO word_info (`text`) VALUES (#{text})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    int addWordInfo(Word word);

    @Insert("INSERT INTO word (id, notation_id) VALUES (#{id}, #{notationId})")
    int addWord(@Param("id") long id, @Param("notationId") long notationId);
}
