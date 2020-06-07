package com.ch.service;

import com.ch.model.CommDisaster;
import org.springframework.stereotype.Service;

@Service
public interface CommDisasterService {
//    int deleteByPrimaryKey(Integer idcommdisaster);

    int insert(CommDisaster record);

//    int insertSelective(CommDisaster record);
//
//    CommDisaster selectByPrimaryKey(Integer idcommdisaster);
//
//    int updateByPrimaryKeySelective(CommDisaster record);
//
//    int updateByPrimaryKeyWithBLOBs(CommDisaster record);
//
//    int updateByPrimaryKey(CommDisaster record);
}
