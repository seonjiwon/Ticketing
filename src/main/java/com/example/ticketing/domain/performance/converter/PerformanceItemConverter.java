package com.example.ticketing.domain.performance.converter;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceHall;
import com.example.ticketing.domain.performance.entity.PerformanceItem;

public class PerformanceItemConverter {

    public static PerformanceItem of(Performance performance, PerformanceDto.PerformanceItemDto performanceItemDto, PerformanceHall performanceHall) {
        return PerformanceItem.builder()
                .performance(performance)
                .performanceHall(performanceHall)
                .startDate(performanceItemDto.startDate())
                .endDate(performanceItemDto.endDate())
                .time(performanceItemDto.time())
                .build();
    }
}
