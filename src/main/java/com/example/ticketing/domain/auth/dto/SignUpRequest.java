package com.example.ticketing.domain.auth.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;
}
