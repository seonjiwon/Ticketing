package com.example.ticketing.domain.auth.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {

    private CustomerDto customerDto;

    public CustomUserDetails(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return customerDto.getPassword();
    }

    @Override
    public String getUsername() {
        return customerDto.getEmail();
    }
}
