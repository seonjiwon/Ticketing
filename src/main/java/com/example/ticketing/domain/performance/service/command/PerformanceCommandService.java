package com.example.ticketing.domain.performance.service.command;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceCommandService {
    PerformanceDto.CreateResponse createPerformance(PerformanceDto.CreateRequest request);

    List<PerformanceDto.PerformanceItemDto> getPerformanceList(Category category, LocalDate cursor);
}
