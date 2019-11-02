package com.learn.mapper;

import com.learn.model.Book;
import com.learn.model.User;
import com.learn.model.UserWord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUser(long id);


    @Select("SELECT * FROM book, user_book AND user_id = #{id} AND book.id = book_id")
    List<Book> getBooks(long id);

    @Select("SELECT * FROM book, current_book AND user_id = #{id} AND book.id = book_id")
    Book getCurrentBook(long id);

    @Update("UPDATE current_book SET bookId = #{bookId} WHERE user_id = #{userId}")
    int selectBook(@Param("userId") long userId, @Param("bookId") long bookId);

    @Insert("INSERT INTO user (open_id, nickname, avatar_url, gender, country, province, city) VALUES " +
            "(#{openId}, #{nickname}, #{avatarUrl}, #{gender}, #{county}, #{province}, #{city})")
    int addUser(User user);

    @Insert("INSERT INTO user_word (user_id, word_id, weight) " +
            "SELECT #{userId}, #{wordId}, 0 " +
            "FROM dual " +
            "WHERE NOT EXISTS(select * FROM user_word WHERE user_id = #{userId} AND word_id = #{wordId})")
    int addWordIntoUser(@Param("wordId") long wordId, @Param("userId") long userId);

    @Update("UPDATE user_word SET weight = #{weight} WHERE user_id = #{userId} AND word_id = #{wordId}")
    int updateWeight(@Param("userId") long userId, @Param("wordId") long wordId, @Param("weight") int weight);

    @Select("<script>" +
            "SELECT * FROM word, word_info, user_word, chapter_word_relation WHERE " +
            "user_word.user_id = #{userId} AND " +
            "user_word.word_id = word.id AND " +
            "user_word.weight &lt; #{weight} AND " +
            "word.id = word_info.id AND " +
            "chapter_word_relation.word_id = word.id AND " +
            "chapter_word_relation.chapter_id in" +
            "<foreach collection='chapters' open='(' item='id' separator=',' close=')'>#{id}</foreach> "+
            "LIMIT #{size}"+
            "</script>")
    @Results({
            @Result(column = "notation_id", property = "notation",
                    one = @One(select = "com.learn.mapper.NotationMapper.getNotation")),
            @Result(column = "id", property = "means",
                    many = @Many(select = "com.learn.mapper.MeanMapper.getMeansByWordId")),
            @Result(column = "id", property = "sentences",
                    many = @Many(select = "com.learn.mapper.SentenceMapper.getSentencesByWordId")
            )
    })
    List<UserWord> getUserWords(@Param("userId") long userId, @Param("chapters") List<Integer> chapterIds, @Param("weight") long grWeight, @Param("size") int size);
}
