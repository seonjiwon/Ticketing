package com.example.ticketing.domain.performance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "performance_hall")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class PerformanceHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_hall_id")
    private Long id;

    private String venue; // 공연장 이름
}
