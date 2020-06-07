package com.ch.service;

import com.ch.model.CivilStructure;
import org.springframework.stereotype.Service;

@Service
public interface CivilStructureService {
    int insert(CivilStructure record);
}
