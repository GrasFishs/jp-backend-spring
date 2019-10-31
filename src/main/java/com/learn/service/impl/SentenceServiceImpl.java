package com.learn.service.impl;

import com.learn.mapper.SentenceMapper;
import com.learn.model.Sentence;
import com.learn.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private SentenceMapper sentenceMapper;

    @Transactional
    @Override
    public long addSentence(Sentence sentence) {
        return sentenceMapper.addSentence(sentence);
    }
}
