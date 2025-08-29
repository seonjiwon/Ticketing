package com.example.ticketing.domain.performance.repository;

import com.example.ticketing.domain.performance.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
