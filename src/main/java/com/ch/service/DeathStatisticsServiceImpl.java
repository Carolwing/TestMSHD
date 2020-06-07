package com.ch.service;

import com.ch.mapping.DeathStatisticsMapper;
import com.ch.model.DeathStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeathStatisticsServiceImpl implements DeathStatisticsService{
    @Autowired
    DeathStatisticsMapper deathStatisticsMapper;

    @Override
    public int insert(DeathStatistics record) {
        return deathStatisticsMapper.insert(record);
    }
}
