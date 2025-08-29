package com.example.ticketing.domain.performance.repository;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}
