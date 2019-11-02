package com.learn.mapper;

import com.learn.model.Chapter;
import com.learn.model.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ChapterMapper {


    @Select("SELECT * FROM chapter WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "words", one = @One(select = "com.learn.mapper.ChapterMapper.getWordsByChapter"))
    })
    Chapter getChapter(long id);

    @Select("SELECT * FROM chapter WHERE id = #{id}")
    Chapter getSimpleChapter(long id);

    @Select("SELECT * FROM word_info, word, chapter_word_relation WHERE " +
            "chapter_id = #{id} AND " +
            "chapter_word_relation.word_id = word.id AND " +
            "word_info.id = word.id")
    @Results(id = "word", value = {
            @Result(column = "notation_id", property = "notation",
                    one = @One(select = "com.learn.mapper.NotationMapper.getNotation")),
            @Result(column = "id", property = "means",
                    many = @Many(select = "com.learn.mapper.MeanMapper.getMeansByWordId")),
            @Result(column = "id", property = "sentences",
                    many = @Many(select = "com.learn.mapper.SentenceMapper.getSentencesByWordId")
            )
    })
    List<Word> getWordsByChapter(long id);

    @Insert("INSERT INTO chapter (id , title, word_count) VALUES (#{id}, #{title}, 0)")
    int addChapter(Chapter chapter);

    @Insert("INSERT INTO book_chapter (book_id, chapter_id) VALUES (#{bookId}, #{chapterId})")
    int addChpaterIntoBook(@Param("chapterId") long chapterId, @Param("bookId") int bookId);

    @Insert("INSERT INTO chapter_word_relation (chapter_id, word_id) VALUES (#{chapterId}, #{wordId})")
    int addWordIntoChapter(@Param("chapterId") long chapterId, @Param("wordId") long wordId);

    @Update("UPDATE chapter SET word_count = word_count + #{count} WHERE id = #{chapterId}")
    int updateChapterWordCount(@Param("chapterId") int chapterId, @Param("count") int count);
}
