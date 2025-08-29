package com.example.ticketing.domain.performance.service.command.v0;

import com.example.ticketing.domain.performance.converter.PerformanceConverter;
import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.performance.repository.PerformanceRepository;
import com.example.ticketing.domain.performance.service.command.PerformanceCommandService;
import com.example.ticketing.domain.performance.service.command.PerformanceItemCommandService;
import com.example.ticketing.domain.performance.service.command.PriceCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PerformanceCommandServiceV0 implements PerformanceCommandService {

    private final PerformanceItemCommandService performanceItemCommandService;
    private final PriceCommandService priceCommandService;

    private final PerformanceRepository performanceRepository;

    @Override
    public PerformanceDto.CreateResponse createPerformance(PerformanceDto.CreateRequest request) {
        // 1. Performance 생성
        Performance performance = PerformanceConverter.of(request.category(), request.name());
        Performance savedPerformance = performanceRepository.save(performance);

        // 2. PerformanceItem 생성
        PerformanceItem savedPerformanceItem = performanceItemCommandService.createPerformanceItem(performance, request.performanceItem());

        // 3. Price 할당
        priceCommandService.allocate(savedPerformanceItem, request.sectionConfigs());

        return PerformanceConverter.toCreateResponse(savedPerformance, savedPerformanceItem);
    }

    @Override
    public List<PerformanceDto.PerformanceItemDto> getPerformanceList(Category category, LocalDate cursor) {
        return List.of();
    }
}
