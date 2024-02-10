package com.example.StreetLightFaultDetection.repository;

import com.example.StreetLightFaultDetection.Entity.LightDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDetailRepository extends JpaRepository<LightDetail,Integer> {
}
