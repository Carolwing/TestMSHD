package com.ch.service;

import com.ch.mapping.CommDisasterMapper;
import com.ch.model.CommDisaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommDisasterServiceImpl implements CommDisasterService {
    @Autowired
    CommDisasterMapper commDisasterMapper;

//    public int deleteByPrimaryKey(Integer idcommdisaster) {
//        return 0;
//    }
    @Override
    public int insert(CommDisaster record) {
        return commDisasterMapper.insert(record);
    }

//    public int insertSelective(CommDisaster record) {
//        return 0;
//    }
//
//    public CommDisaster selectByPrimaryKey(Integer idcommdisaster) {
//        return commDisasterMapper.selectByPrimaryKey(idcommdisaster);
//    }
//
//    public int updateByPrimaryKeySelective(CommDisaster record) {
//        return 0;
//    }
//
//    public int updateByPrimaryKeyWithBLOBs(CommDisaster record) {
//        return 0;
//    }
//
//    public int updateByPrimaryKey(CommDisaster record) {
//        return 0;
//    }
}
