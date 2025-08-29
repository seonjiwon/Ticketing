package com.example.ticketing.domain.performance.repository;

import com.example.ticketing.domain.performance.entity.PerformanceHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceHallRepository extends JpaRepository<PerformanceHall, Long> {
}
