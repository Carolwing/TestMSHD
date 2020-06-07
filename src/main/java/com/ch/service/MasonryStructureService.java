package com.ch.service;

import com.ch.mapping.MasonryStructureMapper;
import com.ch.model.MasonryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasonryStructureService {
    @Autowired
    MasonryStructureMapper masonryStructureMapper;

    public int insert(MasonryStructure record) {
        return masonryStructureMapper.insert(record);
    }
}
