package com.learn.service.impl;

import com.learn.mapper.MeanMapper;
import com.learn.model.Mean;
import com.learn.service.MeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MeanServiceImpl implements MeanService {

    @Autowired
    private MeanMapper meanMapper;

    @Transactional
    @Override
    public long addMean(Mean mean, int speechId) {
        meanMapper.addMeanInfo(mean);
        meanMapper.addMean(mean.getId(), speechId);
        return mean.getId();
    }
}
