package com.ch.service;

import com.ch.mapping.TrafficDisasterMapper;
import com.ch.model.TrafficDisaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficDisasterService {
    @Autowired
    TrafficDisasterMapper trafficDisasterMapper;

    //    public int deleteByPrimaryKey(Integer idcommdisaster) {
//        return 0;
//    }
    public int insert(TrafficDisaster record) {
        return trafficDisasterMapper.insert(record);
    }
}
