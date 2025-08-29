package com.example.ticketing.domain.performance.service.query;

import com.example.ticketing.domain.performance.entity.PerformanceHall;

public interface PerformanceHallQueryService {
    PerformanceHall getPerformanceHall(Long performanceHallId);
}
