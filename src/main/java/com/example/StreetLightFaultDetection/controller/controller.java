package com.example.StreetLightFaultDetection.controller;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import com.example.StreetLightFaultDetection.service.Service;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
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

    @GetMapping(value = "/faultDetected")
    public String faultDetected(@RequestParam("id") String id, @RequestParam boolean status){
        int intValue = Integer.parseInt(id);
        return service.faultDetected(intValue,status);
    }
}
