package com.example.ticketing.domain.performance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "performance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;
}
