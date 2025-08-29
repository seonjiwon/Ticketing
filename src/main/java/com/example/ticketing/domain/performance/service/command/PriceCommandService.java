package com.example.ticketing.domain.performance.service.command;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.PerformanceItem;

import java.util.List;

public interface PriceCommandService {
    void allocate(PerformanceItem performanceItem, List<PerformanceDto.SectionConfigs> sectionConfigs);
}
