package com.learn.service;

import com.learn.model.UserWord;
import com.learn.model.Word;

import java.util.List;

public interface WordService {

    Word getWord(long id);

    List<UserWord> getWordsByUserId(long id, List<Integer> chapterIds, int grWeight, int size);

    long addWord(Word word);
}
