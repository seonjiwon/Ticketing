package com.example.ticketing.domain.performance.entity;

import com.example.ticketing.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "performance_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class PerformanceItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_hall_id")
    private PerformanceHall performanceHall;

    private LocalDate startDate; // 공연 시작일

    private LocalDate endDate; // 공연 종료일

    private LocalTime time; // 공연 시간
}
