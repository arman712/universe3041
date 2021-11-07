package com.example.universe3041.service.impl;

import com.example.universe3041.model.Lord;
import com.example.universe3041.repo.LordRepository;
import com.example.universe3041.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LordServiceImpl implements LordService {

    @Autowired
    LordRepository lordRepository;

    @Override
    public Lord add(Lord lord) {
        return lordRepository.save(lord);
    }

    @Override
    public List<Lord> findAllIdleLords() {
        return lordRepository.findAllByPlanetsIsNull();
    }

    @Override
    public List<Lord> findTOP10YoungLords() {
        return lordRepository.getAllOrderByAgeLimit10();
    }
}
