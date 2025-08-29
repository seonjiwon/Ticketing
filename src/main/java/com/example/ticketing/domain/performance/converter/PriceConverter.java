package com.example.ticketing.domain.performance.converter;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.performance.entity.Price;

public class PriceConverter {
    public static Price of(PerformanceItem performanceItem, PerformanceDto.SectionConfigs sectionConfig) {
        return Price.builder()
                .performanceItem(performanceItem)
                .section(sectionConfig.section())
                .price(sectionConfig.price())
                .build();
    }
}
