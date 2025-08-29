package com.example.ticketing.domain.performance.converter;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceItem;

public class PerformanceConverter {
    public static Performance of(Category category, String name) {
        return Performance.builder()
                .category(category)
                .name(name)
                .build();
    }

    public static PerformanceDto.CreateResponse toCreateResponse(Performance performance, PerformanceItem performanceItem) {
        return PerformanceDto.CreateResponse.builder()
                .name(performance.getName())
                .category(performance.getCategory())
                .startDate(performanceItem.getStartDate())
                .endDate(performanceItem.getEndDate())
                .time(performanceItem.getTime())
                .build();
    }
}
