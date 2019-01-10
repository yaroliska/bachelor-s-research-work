package com.example.demo.repository;

import com.example.demo.model.GlobalVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalVersionRepository extends JpaRepository<GlobalVersion, Long> {
}
