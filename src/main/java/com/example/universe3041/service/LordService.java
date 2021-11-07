package com.example.universe3041.service;

import com.example.universe3041.model.Lord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LordService {

    Lord add(Lord lord);
    List<Lord> findAllIdleLords();
    List<Lord> findTOP10YoungLords();
}
