package com.example.ticketing.domain.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDto {
    private String email;
    private String password;
}
