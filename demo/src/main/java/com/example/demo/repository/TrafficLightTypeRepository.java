package com.example.demo.repository;

import com.example.demo.model.TrafficLightType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficLightTypeRepository extends JpaRepository<TrafficLightType, Long> {
}
