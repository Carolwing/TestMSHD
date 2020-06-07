package com.ch.service;

import com.ch.mapping.DisasterPredictionMapper;
import com.ch.model.DisasterPrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisasterPredictionServiceImpl implements DisasterPredictionService{
    @Autowired
    DisasterPredictionMapper disasterPredictionMapper;

    @Override
    public int insert(DisasterPrediction record) {
        return disasterPredictionMapper.insert(record);
    }
}
