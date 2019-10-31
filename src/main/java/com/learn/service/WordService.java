package com.learn.service;

import com.learn.model.Word;

import java.util.List;

public interface WordService {

    Word getWord(long id);

    List<Word> getWords();

    long addWord(Word word);
}
