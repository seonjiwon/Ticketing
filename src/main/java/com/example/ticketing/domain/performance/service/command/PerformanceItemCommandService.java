package com.example.ticketing.domain.performance.service.command;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceItem;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceItemCommandService {
    PerformanceItem createPerformanceItem(Performance performance, PerformanceDto.PerformanceItemDto performanceItemDto);

    List<PerformanceDto.PerformanceItemDetail> getPerformanceDetail(Long performanceId, Long performanceItemId);
}
