package com.example.ticketing.domain.auth.service;

import com.example.ticketing.domain.auth.converter.CustomerConverter;
import com.example.ticketing.domain.auth.dto.CustomUserDetails;
import com.example.ticketing.domain.auth.dto.CustomerDto;
import com.example.ticketing.domain.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CustomerDto customerDto = userRepository.findByEmail(email)
                .map(CustomerConverter::toCustomerDto)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + email));

        return new CustomUserDetails(customerDto);
    }
}
