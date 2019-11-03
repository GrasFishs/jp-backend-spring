package com.learn.service.impl;

import com.learn.mapper.*;

import com.learn.model.*;
import com.learn.service.WordService;
import com.learn.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private MeanMapper meanMapper;

    @Autowired
    private NotationMapper notationMapper;

    @Autowired
    private SentenceMapper sentenceMapper;

    @Autowired
    private ToneMapper toneMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Word getWord(long id) {
        return wordMapper.getWord(id);
    }

    @Override
    public List<UserWord> getWordsByUserId(long id, List<Integer> chapterIds, int grWeight, int size) {
        return userMapper.getUserWords(id, chapterIds, grWeight, size);
    }


    @Transactional
    @Override
    public long addWord(Word word) {
        long wordId;
        long notationId;
        wordMapper.addWordInfo(word);
        notationMapper.addNotation(word.getNotation());
        wordId = word.getId();
        notationId = word.getNotation().getId();
        wordMapper.addWord(wordId, notationId);
        for (Tone tone : word.getNotation().getTones()) {
            toneMapper.addTone(tone);
            notationMapper.addNotationTone(notationId, tone.getId());
        }
        for (Mean mean : word.getMeans()) {
            long meanId;
            meanMapper.addMeanInfo(mean);
            meanId = mean.getId();
            meanMapper.addMean(meanId, mean.getSpeech().getId());
            meanMapper.addWordMean(meanId, wordId);
        }
        for (Sentence st : word.getSentences()) {
            sentenceMapper.addSentence(st);
            sentenceMapper.addWordSentence(st.getId(), wordId);
        }
        return wordId;
    }

    public List<UserWord> getUserWords(long id, List<Integer> chapterIds, int grWeight, int size) {
        return userMapper.getUserWords(id, chapterIds, grWeight, size);
    }
}
