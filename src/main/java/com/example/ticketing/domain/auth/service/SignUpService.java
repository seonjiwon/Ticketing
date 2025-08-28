package com.example.ticketing.domain.auth.service;

import com.example.ticketing.common.exception.CustomException;
import com.example.ticketing.domain.auth.dto.SignUpRequest;
import com.example.ticketing.domain.user.code.CustomerErrorCode;
import com.example.ticketing.domain.user.entity.Customer;
import com.example.ticketing.domain.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SignUpService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public Customer signUp(SignUpRequest request) {

        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(CustomerErrorCode.DUPLICATE_USER);
        }

        Customer customer = Customer.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();

        return customerRepository.save(customer);
    }
}
