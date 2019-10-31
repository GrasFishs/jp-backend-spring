package com.learn.service.impl;

import com.learn.mapper.ToneMapper;
import com.learn.model.Tone;
import com.learn.service.ToneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToneServiceImpl implements ToneService {

    @Autowired
    private ToneMapper toneMapper;

    @Override
    public long addTone(Tone tone) {
        return toneMapper.addTone(tone);
    }
}
