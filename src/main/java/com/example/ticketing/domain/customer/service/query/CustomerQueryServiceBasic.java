package com.example.ticketing.domain.customer.service.query;

import com.example.ticketing.common.exception.CustomException;
import com.example.ticketing.domain.customer.code.CustomerErrorCode;
import com.example.ticketing.domain.customer.entity.Customer;
import com.example.ticketing.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerQueryServiceBasic implements CustomerQueryService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(CustomerErrorCode.CUSTOMER_NOT_FOUND));
    }
}
