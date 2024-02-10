package com.example.StreetLightFaultDetection.controller;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import com.example.StreetLightFaultDetection.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private Service service;

    @GetMapping(value = "/welcome")
    public String welcome(){
        return"welcome";
    }

    @PostMapping(value = "/createLightDetail")
    public String createLightDetail(@RequestBody LightDetail lightDetail){
        return service.createLightDetail(lightDetail);
    }

    @GetMapping(value = "/getAllLightDetail")
    public List<LightDetail> getAllLightDetail(){
        return service.getAllLightDetails();
    }

    @PostMapping(value = "/faultDetected/{id}")
    public String faultDetected(@PathVariable("id") int id){
        return service.faultDetected(id);
    }
}
