package com.example.ticketing.domain.customer.service.query;


import com.example.ticketing.domain.customer.entity.Customer;

public interface CustomerQueryService {
    Customer findByEmail(String email);
}
