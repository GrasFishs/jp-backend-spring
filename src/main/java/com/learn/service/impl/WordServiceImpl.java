package com.learn.service.impl;

import com.learn.mapper.*;

import com.learn.model.Mean;
import com.learn.model.Sentence;
import com.learn.model.Tone;
import com.learn.model.Word;
import com.learn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Word getWord(long id) {
        return wordMapper.getWord(id);
    }

    @Override
    public List<Word> getWords() {
        return wordMapper.getWords();
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
}
