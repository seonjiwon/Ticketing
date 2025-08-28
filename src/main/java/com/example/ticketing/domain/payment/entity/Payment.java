package com.example.ticketing.domain.payment.entity;

import com.example.ticketing.common.entity.BaseEntity;
import com.example.ticketing.domain.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private int totalPrice;

    private PaymentStatus status;
}
