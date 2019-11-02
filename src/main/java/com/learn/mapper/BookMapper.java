package com.learn.mapper;

import com.learn.model.Book;
import com.learn.model.Chapter;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {


    @Select("SELECT * FROM book WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "chapters", one = @One(select = "getSimpleChaptersByBook"))
    })
    Book getBook(int id);

    @Select("SELECT * FROM book_chapter, chapter WHERE book_id = #{id} AND chapter.id = chapter_id")
    List<Chapter> getSimpleChaptersByBook(int id);

    @Insert("INSERT INTO book (name, description, cover) VALUES (#{name}, #{description}, #{cover})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int addBook(Book book);

    @Insert("INSERT INTO book_chapter (chapter_id, book_id) VALUES (#{chapterId}, #{bookId})")
    int addChapterIntoBook(@Param("chapterId") long chapterId, @Param("bookId") long bookId);
}
