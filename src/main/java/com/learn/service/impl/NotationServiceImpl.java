package com.learn.service.impl;

import com.learn.mapper.NotationMapper;
import com.learn.model.Notation;
import com.learn.service.NotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotationServiceImpl implements NotationService {

    @Autowired
    private NotationMapper notationMapper;

    @Transactional
    @Override
    public long addNotation(Notation notation, List<Long> tonesIds) {
        notationMapper.addNotation(notation);
        long id = notation.getId();
        for (Long toneId : tonesIds) {
            notationMapper.addNotationTone(id, toneId);
        }
        return id;
    }
}
