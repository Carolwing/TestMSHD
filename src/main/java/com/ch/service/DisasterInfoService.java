package com.ch.service;

import com.ch.model.DisasterInfo;
import com.ch.mapping.DisasterInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Data 2020/5/27 11:18
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class DisasterInfoService {

    @Autowired
    DisasterInfoMapper disasterInfoMapper;

    public int insert(DisasterInfo disasterInfo) {
        return disasterInfoMapper.insert(disasterInfo);
    }
}
