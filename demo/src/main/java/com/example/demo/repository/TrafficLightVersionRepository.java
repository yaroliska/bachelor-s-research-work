package com.example.demo.repository;

import com.example.demo.model.TrafficLightVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficLightVersionRepository extends JpaRepository<TrafficLightVersion,Long> {
}
