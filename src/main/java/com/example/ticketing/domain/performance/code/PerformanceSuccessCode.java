package com.example.ticketing.domain.performance.code;

import com.example.ticketing.common.code.success.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PerformanceSuccessCode implements BaseSuccessCode {

    PERFORMANCE_INFO_RETRIEVED(HttpStatus.OK, "PERFORMANCE200", "공연 조회에 성공했습니다."),
    PERFORMANCE_CREATE_SUCCESS(HttpStatus.CREATED, "PERFORMANCE201", "공연 생성에 성공했습니다."),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
