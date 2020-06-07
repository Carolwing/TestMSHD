package com.ch.mapping;

import com.ch.model.CommDisaster;
//import org.apache.ibatis.annotations.Mapper;

//@Mapper()
public interface CommDisasterMapper {
    int insert(CommDisaster record);

//    int insertSelective(CommDisaster record);
//
//    CommDisaster selectByPrimaryKey(Integer idCommDisaster);
//
//    int updateByPrimaryKeySelective(CommDisaster record);
//
//    int updateByPrimaryKeyWithBLOBs(CommDisaster record);
//
//    int updateByPrimaryKey(CommDisaster record);
}