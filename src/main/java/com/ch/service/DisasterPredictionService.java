package com.ch.service;

import com.ch.model.DisasterPrediction;
import org.springframework.stereotype.Service;

@Service
public interface DisasterPredictionService {
    int insert(DisasterPrediction record);
}
