package com.example.universe3041.controller;

import com.example.universe3041.model.Lord;
import com.example.universe3041.model.Planet;
import com.example.universe3041.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Planet planet){
        Planet newPlanet = planetService.add(planet);
        return ResponseEntity.ok(newPlanet);
    }

    @RequestMapping(value = "/destroy",method = RequestMethod.POST)
    public ResponseEntity<?> destroy(@RequestBody Planet planet){
        planetService.delete(planet);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/assign",method = RequestMethod.POST)
    public ResponseEntity<?>assignOverLord(@RequestParam String planetID, @RequestParam String lordID){

        planetService.assignTheOverlord(planetID,lordID);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
