package com.example.StreetLightFaultDetection.controller;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import com.example.StreetLightFaultDetection.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Page<LightDetail> getAllLightDetail(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "id,asc") String[] sort,
                                               @RequestParam(defaultValue = "") String key){
        return service.getAllLightDetails(page, size, sort, key);
    }

    @GetMapping(value = "/faultDetected/{id}")
    public String faultDetected(@PathVariable("id") int id,@RequestParam boolean status){
        return service.faultDetected(id,status);
    }
}
