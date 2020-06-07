package com.ch.service;

import com.ch.model.DeathStatistics;
import org.springframework.stereotype.Service;

@Service
public interface DeathStatisticsService {
    int insert(DeathStatistics record);
}
