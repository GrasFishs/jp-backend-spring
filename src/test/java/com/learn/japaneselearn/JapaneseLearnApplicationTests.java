package com.learn.japaneselearn;

import com.learn.mapper.BookMapper;
import com.learn.mapper.ChapterMapper;
import com.learn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootTest
class JapaneseLearnApplicationTests {

    @Resource
    private ChapterMapper chapterMapper;

    @Resource
    private BookMapper bookMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    void chapter() {
        System.out.println(chapterMapper.getChapter(1));
    }

    @Test
    void book() {
        System.out.println(bookMapper.getBook(1));
    }

    @Test
    void words() {
        userMapper.getUserWords(1, Arrays.asList(1, 2), 90, 10).stream().forEach(System.out::println);
    }

    @Test
    void contextLoads() {
    }

}
