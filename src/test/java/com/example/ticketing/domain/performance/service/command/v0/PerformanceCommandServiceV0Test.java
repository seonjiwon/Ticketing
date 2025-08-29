package com.example.ticketing.domain.performance.service.command.v0;

import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.Performance;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.performance.repository.PerformanceRepository;
import com.example.ticketing.domain.performance.service.query.PerformanceHallQueryService;
import com.example.ticketing.domain.seat.entity.Section;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PerformanceCommandServiceV0Test {

    @Mock
    PerformanceItemCommandServiceV0 performanceItemCommandService;

    @Mock
    PriceCommandServiceV0 priceCommandService;

    @Mock
    PerformanceRepository performanceRepository;

    @InjectMocks
    PerformanceCommandServiceV0 performanceCommandService;

    @Test
    @DisplayName("정상적인 요청시 성공한다")
    void 정상_공연_생성_성공() throws Exception {
        // given
        String expectedName = "테스트 이름";
        Category category = Category.CONCERT;
        PerformanceDto.CreateRequest request = PerformanceDto.CreateRequest.builder()
                .category(Category.CONCERT)
                .name("테스트 이름")
                .performanceItem(createPerformanceItemDto(1L, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 6), LocalTime.of(17, 30)))
                .sectionConfigs(List.of(
                        createSectionConfig(Section.VIP, 170_000)
                ))
                .build();

        Performance savedPerformance = createPerformance(1L, category, expectedName);
        PerformanceItem savedPerformanceItem = createPerformanceItem(1L, savedPerformance, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 6), LocalTime.of(17, 30));

        when(performanceRepository.save(any(Performance.class))).thenReturn(savedPerformance);
        when(performanceItemCommandService.createPerformanceItem(any(), any())).thenReturn(savedPerformanceItem);

        // when
        PerformanceDto.CreateResponse response = performanceCommandService.createPerformance(request);

        // then
        assertThat(response.category()).isEqualTo(category);
        assertThat(response.name()).isEqualTo(expectedName);

        verify(performanceRepository).save(any(Performance.class));
        verify(performanceItemCommandService).createPerformanceItem(any(Performance.class), any());
        verify(priceCommandService).allocate(any(), any());
    }

    @Test
    @DisplayName("콘서트 미기입시 실패")
    void 비정상_공연_생성_실패() throws Exception{
        // given
        PerformanceDto.CreateRequest request = PerformanceDto.CreateRequest.builder()
                .category(null)
                .name("테스트 이름")
                .performanceItem(createPerformanceItemDto(1L, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 6), LocalTime.of(17, 30)))
                .sectionConfigs(List.of(
                        createSectionConfig(Section.VIP, 170_000)
                ))
                .build();

        // when

        // then
    }


    private PerformanceDto.PerformanceItemDto createPerformanceItemDto(
            Long performanceHallId,
            LocalDate startDate,
            LocalDate endDate,
            LocalTime time
    ) {
        return PerformanceDto.PerformanceItemDto.builder()
                .performanceHallId(performanceHallId)
                .startDate(startDate)
                .endDate(endDate)
                .time(time)
                .build();
    }

    private PerformanceDto.SectionConfigs createSectionConfig(Section section, int price) {
        return PerformanceDto.SectionConfigs.builder()
                .section(section)
                .price(price)
                .build();
    }

    private Performance createPerformance(Long id, Category category, String name) {
        return Performance.builder()
                .id(id)
                .category(category)
                .name(name)
                .build();
    }

    private PerformanceItem createPerformanceItem(Long id, Performance performance, LocalDate startDate, LocalDate endDate, LocalTime time) {
        return PerformanceItem.builder()
                .id(id)
                .performance(performance)
                .startDate(startDate)
                .endDate(endDate)
                .time(time)
                .build();
    }
}