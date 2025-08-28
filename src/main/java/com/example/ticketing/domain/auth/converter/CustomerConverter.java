package com.example.ticketing.domain.auth.converter;

import com.example.ticketing.domain.auth.dto.SignUpResponse;
import com.example.ticketing.domain.auth.dto.CustomerDto;
import com.example.ticketing.domain.customer.entity.Customer;

public class CustomerConverter {
    public static SignUpResponse toSignUpResponse(Customer customer) {
        return SignUpResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .name(customer.getName())
                .createdAt(customer.getCreatedAt())
                .build();
    }

    public static CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .email(customer.getEmail())
                .password(customer.getPassword())
                .build();
    }
}
