package com.example.ticketing.domain.performance.repository;

import com.example.ticketing.domain.performance.entity.PerformanceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceItemRepository extends JpaRepository<PerformanceItem, Long> {
}
