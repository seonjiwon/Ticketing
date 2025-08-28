package com.example.ticketing.domain.auth.controller;

import com.example.ticketing.common.CustomResponse;
import com.example.ticketing.domain.auth.converter.CustomerConverter;
import com.example.ticketing.domain.auth.dto.SignUpRequest;
import com.example.ticketing.domain.auth.dto.SignUpResponse;
import com.example.ticketing.domain.auth.service.SignUpService;
import com.example.ticketing.domain.customer.code.CustomerSuccessCode;
import com.example.ticketing.domain.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public CustomResponse<SignUpResponse> join(@RequestBody SignUpRequest request) {
        Customer customer = signUpService.signUp(request);

        return CustomResponse.onSuccess(CustomerSuccessCode.SIGNUP_SUCCESS, CustomerConverter.toSignUpResponse(customer));
    }
}
