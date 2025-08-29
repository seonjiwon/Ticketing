package com.example.ticketing.domain.seat.entity;

import com.example.ticketing.domain.performance.entity.PerformanceHall;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_hall_id")
    private PerformanceHall performanceHall;

    @Enumerated(EnumType.STRING)
    private Section section; // VIP, R, S

    private int rowNo; // 행

    private int colNo; // 열
}
