package com.example.ticketing.domain.performance.service.command.v0;

import com.example.ticketing.domain.performance.converter.PerformanceConverter;
import com.example.ticketing.domain.performance.converter.PerformanceItemConverter;
import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceHall;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.performance.repository.PerformanceItemRepository;
import com.example.ticketing.domain.performance.service.command.PerformanceItemCommandService;
import com.example.ticketing.domain.performance.service.query.PerformanceHallQueryService;
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
public class PerformanceItemCommandServiceV0 implements PerformanceItemCommandService {

    private final PerformanceItemRepository performanceItemRepository;

    private final PerformanceHallQueryService performanceHallQueryService;

    @Override
    public PerformanceItem createPerformanceItem(Performance performance, PerformanceDto.PerformanceItemDto performanceItemDto) {
        // 1. PerformanceHall 정보 가져오기
        PerformanceHall performanceHall = performanceHallQueryService.getPerformanceHall(performanceItemDto.performanceHallId());

        // PerformanceItem 생성
        PerformanceItem performanceItem = PerformanceItemConverter.of(performance, performanceItemDto, performanceHall);

        return performanceItemRepository.save(performanceItem);
    }

    @Override
    public List<PerformanceDto.PerformanceItemDetail> getPerformanceDetail(Long performanceId, Long performanceItemId) {
        return List.of();
    }
}
