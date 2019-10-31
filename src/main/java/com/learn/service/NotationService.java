package com.learn.service;

import com.learn.model.Notation;

import java.util.List;

public interface NotationService {

    long addNotation(Notation notation, List<Long> tonesIds);
}
