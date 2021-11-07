package com.example.universe3041.service;

import com.example.universe3041.model.Lord;
import com.example.universe3041.model.Planet;
import org.springframework.stereotype.Service;

@Service
public interface PlanetService {

    Planet add(Planet planet);
    void delete(Planet planet);
    boolean assignTheOverlord(String planetID,String lordID);
}
