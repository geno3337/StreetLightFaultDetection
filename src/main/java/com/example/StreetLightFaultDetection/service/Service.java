package com.example.StreetLightFaultDetection.service;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import com.example.StreetLightFaultDetection.repository.LightDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private LightDetailRepository lightDetailRepository;

    public String createLightDetail(LightDetail lightDetail){
        lightDetailRepository.save(lightDetail);
        return "saved";
    }

    public Page<LightDetail> getAllLightDetails(int page, int size, String[] sort, String key){
        Sort sorting = Sort.by(Sort.Direction.fromString(sort[1]), sort[0]);
        Pageable pageRequest = PageRequest.of(page, size, sorting);
        if (key==null){
            return lightDetailRepository.findAll(pageRequest);
        }
        return lightDetailRepository.search(key,pageRequest);
    }

    public String faultDetected(int id,boolean status){
        if(lightDetailRepository.existsById(id)) {
            Optional<LightDetail> lightDetail = lightDetailRepository.findById(id);
            LightDetail light=lightDetail.get();
//            boolean b1=Boolean.parseBoolean(status);
            light.setFault(status);
            lightDetailRepository.save(light);
            return "success";
        }
        return "id does not exist";
    }

}
