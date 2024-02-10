package com.example.StreetLightFaultDetection.service;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import com.example.StreetLightFaultDetection.repository.LightDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private LightDetailRepository lightDetailRepository;

    public String createLightDetail(LightDetail lightDetail){
        lightDetailRepository.save(lightDetail);
        return "saved";
    }

    public List<LightDetail> getAllLightDetails(){
        return lightDetailRepository.findAll();
    }

    public String faultDetected(int id){
        if(lightDetailRepository.existsById(id)) {
            Optional<LightDetail> lightDetail = lightDetailRepository.findById(id);
            LightDetail light=lightDetail.get();
            light.setFault(true);
            lightDetailRepository.save(light);
            return "success";
        }
        return "id does not exist";
    }

}
