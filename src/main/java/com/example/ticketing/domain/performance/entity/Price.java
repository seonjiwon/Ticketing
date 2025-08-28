package com.example.ticketing.domain.performance.entity;


import com.example.ticketing.domain.seat.entity.Section;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Price")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_item_id")
    private PerformanceItem performanceItem;

    @Enumerated(EnumType.STRING)
    private Section section;

    private int price;
}
