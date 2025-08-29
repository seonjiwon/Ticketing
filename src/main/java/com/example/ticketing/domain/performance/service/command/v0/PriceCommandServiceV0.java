package com.example.ticketing.domain.performance.service.command.v0;

import com.example.ticketing.domain.performance.converter.PriceConverter;
import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.performance.entity.Price;
import com.example.ticketing.domain.performance.repository.PriceRepository;
import com.example.ticketing.domain.performance.service.command.PriceCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PriceCommandServiceV0 implements PriceCommandService {

    private final PriceRepository priceRepository;

    @Override
    public void allocate(PerformanceItem performanceItem, List<PerformanceDto.SectionConfigs> sectionConfigs) {
        // 생성할 Price 담은 리스트
        List<Price> toSavePrice = new ArrayList<>();

        // Price 생성
        sectionConfigs.forEach(sectionConfig -> {
            Price price = PriceConverter.of(performanceItem, sectionConfig);
            toSavePrice.add(price);
        });

        // Price 할당
        priceRepository.saveAll(toSavePrice);
    }
}
