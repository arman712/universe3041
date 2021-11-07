package com.example.universe3041.controller;

import com.example.universe3041.model.Lord;
import com.example.universe3041.repo.LordRepository;
import com.example.universe3041.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lord")
public class LordController {

    @Autowired
    private LordService lordService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Lord lord){

        Lord newLord = lordService.add(lord);
        return ResponseEntity.ok(newLord);
    }

    @RequestMapping(value = "/idlers",method = RequestMethod.GET)
    public  ResponseEntity<?> findIdlers(){
        List<Lord> idlers = lordService.findAllIdleLords();
        return ResponseEntity.ok(idlers);
    }

    @RequestMapping (value = "/show_youngest",method = RequestMethod.GET)
    public ResponseEntity<?> findTop10Youngest(){
        List<Lord> youngest = lordService.findTOP10YoungLords();
        return ResponseEntity.ok(youngest);
    }
}
