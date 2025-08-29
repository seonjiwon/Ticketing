package com.example.ticketing.domain.performance.service.query.v0;

import com.example.ticketing.common.exception.CustomException;
import com.example.ticketing.domain.performance.code.PerformanceHallErrorCode;
import com.example.ticketing.domain.performance.entity.PerformanceHall;
import com.example.ticketing.domain.performance.repository.PerformanceHallRepository;
import com.example.ticketing.domain.performance.service.query.PerformanceHallQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PerformanceHallQueryServiceV0 implements PerformanceHallQueryService {

    private final PerformanceHallRepository performanceHallRepository;

    @Override
    public PerformanceHall getPerformanceHall(Long performanceHallId) {
        return performanceHallRepository.findById(performanceHallId)
                .orElseThrow(() -> new CustomException(PerformanceHallErrorCode.PERFORMANCE_HALL_NOT_FOUND));
    }
}
