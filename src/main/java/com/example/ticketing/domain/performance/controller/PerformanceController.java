package com.example.ticketing.domain.performance.controller;

import com.example.ticketing.common.CustomResponse;
import com.example.ticketing.domain.performance.code.PerformanceSuccessCode;
import com.example.ticketing.domain.performance.dto.PerformanceDto;
import com.example.ticketing.domain.performance.service.command.PerformanceCommandService;
import com.example.ticketing.domain.performance.service.command.PerformanceItemCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/performances")
@Slf4j
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceCommandService performanceCommandService;

    @PostMapping
    @Operation(method = "POST", summary = "공연 생성", description = "공연을 생성하는 API 입니다.")
    public CustomResponse<PerformanceDto.CreateResponse> createPerformance(
            @Valid @RequestBody PerformanceDto.CreateRequest request
    ) {
        PerformanceDto.CreateResponse response = performanceCommandService.createPerformance(request);
        return CustomResponse.onSuccess(PerformanceSuccessCode.PERFORMANCE_CREATE_SUCCESS, response);
    }
}
