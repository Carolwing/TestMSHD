package com.ch.service;

import com.ch.mapping.MissingStatisticsMapper;
import com.ch.model.MissingStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissingStatisticsService {
    @Autowired
    MissingStatisticsMapper missingStatisticsMapper;

    public int insert(MissingStatistics record) {
        return missingStatisticsMapper.insert(record);
    }
}
