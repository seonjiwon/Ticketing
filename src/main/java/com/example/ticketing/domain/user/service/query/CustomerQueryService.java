package com.example.ticketing.domain.user.service.query;


import com.example.ticketing.domain.user.entity.Customer;

public interface CustomerQueryService {
    Customer findByEmail(String email);
}
