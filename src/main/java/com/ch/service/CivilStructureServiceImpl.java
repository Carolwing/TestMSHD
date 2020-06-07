package com.ch.service;

import com.ch.mapping.CivilStructureMapper;
import com.ch.model.CivilStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilStructureServiceImpl implements CivilStructureService{
    @Autowired
    CivilStructureMapper civilStructureMapper;

    @Override
    public int insert(CivilStructure record) {
        return civilStructureMapper.insert(record);
    }
}
