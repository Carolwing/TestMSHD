package com.ch.service;

import com.ch.mapping.CollapseRecordMapper;
import com.ch.model.CollapseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollapseRecordServiceImpl implements CollapseRecordService{
    @Autowired
    CollapseRecordMapper collapseRecordMapper;

    @Override
    public int insert(CollapseRecord record) {
        return collapseRecordMapper.insert(record);
    }
}
