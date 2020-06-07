package com.ch.service;


import com.ch.model.LandslideRecord;
import com.ch.mapping.LandslideRecordMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Data 2020/5/27 21:40
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class LandslideRecordService {
    @Autowired
    LandslideRecordMapper landslideRecordMapper;

    public int insert(LandslideRecord landslideRecord){
        return landslideRecordMapper.insert(landslideRecord);
    }//插入一条新数据

}
