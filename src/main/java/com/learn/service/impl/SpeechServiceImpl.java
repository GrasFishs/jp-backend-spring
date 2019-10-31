package com.learn.service.impl;

import com.learn.mapper.SpeechMapper;
import com.learn.model.Speech;
import com.learn.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpeechServiceImpl implements SpeechService {

    @Autowired
    private SpeechMapper speechMapper;

    @Transactional
    @Override
    public int addSpeech(Speech speech) {
        speechMapper.addSpeech(speech);
        return speech.getId();
    }
}
