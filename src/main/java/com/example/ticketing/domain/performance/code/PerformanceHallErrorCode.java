package com.example.ticketing.domain.performance.code;

import com.example.ticketing.common.code.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PerformanceHallErrorCode implements BaseErrorCode {

    PERFORMANCE_HALL_NOT_FOUND(HttpStatus.NOT_FOUND, "PERFORMANCE_HALL404", "공연장을 찾을 수 없습니다."),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
