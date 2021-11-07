package com.example.universe3041.service.impl;

import com.example.universe3041.model.Lord;
import com.example.universe3041.model.Planet;
import com.example.universe3041.repo.LordRepository;
import com.example.universe3041.repo.PlanetRepository;
import com.example.universe3041.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
     private PlanetRepository planetRepository;

    @Autowired
    private LordRepository lordRepository;

    @Override
    public Planet add(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public void delete(Planet planet) {
        planetRepository.delete(planet);
    }

    @Override
    public boolean assignTheOverlord(String planetID,String lordID) {

        Planet planet = planetRepository.getById(Long.parseLong(planetID));
        Lord lord = lordRepository.getById(Long.parseLong(lordID));
        planet.setLord_id(lord.getId());
        planetRepository.save(planet);
        return true;
    }
}
