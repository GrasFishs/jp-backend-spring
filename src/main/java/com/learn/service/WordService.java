package com.learn.service;

import com.learn.model.Word;

public interface WordService {

    Word getWord(long id);

    long addWord(Word word);
}
