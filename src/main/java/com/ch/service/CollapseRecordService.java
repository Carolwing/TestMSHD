package com.ch.service;

import com.ch.model.CollapseRecord;
import org.springframework.stereotype.Service;

@Service
public interface CollapseRecordService {
    int insert(CollapseRecord record);
}
