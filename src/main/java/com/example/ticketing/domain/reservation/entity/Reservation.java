package com.example.ticketing.domain.reservation.entity;

import com.example.ticketing.common.entity.BaseEntity;
import com.example.ticketing.domain.customer.entity.Customer;
import com.example.ticketing.domain.payment.entity.Payment;
import com.example.ticketing.domain.performance.entity.PerformanceItem;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

@Entity
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_item_id")
    private PerformanceItem performanceItem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
