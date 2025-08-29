package com.example.ticketing.domain.performance.dto;

import com.example.ticketing.domain.performance.entity.Category;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import com.example.ticketing.domain.seat.entity.Section;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PerformanceDto {

    public record CreateRequest(
            @NotNull Category category,
            @NotNull String name,
            @NotNull PerformanceItemDto performanceItem,
            @NotNull List<SectionConfigs> sectionConfigs
    ) {
    }

    @Builder
    public record CreateResponse(
            String name,
            Category category,
            LocalDate startDate,
            LocalDate endDate,
            LocalTime time
    ) {
    }

    public record PerformanceItemDetail(

    ) {
    }

    public record PerformanceItemDto(
            @NotNull String title,
            @NotNull Long performanceHallId,
            @NotNull LocalDate startDate,
            @NotNull LocalDate endDate,
            @NotNull LocalTime time
    ) {
    }

    public record SectionConfigs(
            @NotNull Section section,
            @NotNull int price
    ) {
    }
}
