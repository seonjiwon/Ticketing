package com.example.ticketing.domain.customer.code;

import com.example.ticketing.common.code.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomerErrorCode implements BaseErrorCode {

    // 인증 관련
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH401", "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "AUTH403", "접근 권한이 없습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH402", "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH403", "토큰이 만료되었습니다."),
    TOKEN_NOT_FOUND(HttpStatus.BAD_REQUEST, "AUTH404", "토큰이 존재하지 않습니다."),

    // 사용자 관련
    CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND, "CUSTOMER404", "사용자를 찾을 수 없습니다."),
    DUPLICATE_USER(HttpStatus.CONFLICT, "CUSTOMER409", "이미 존재하는 사용자입니다."),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "CUSTOMER400", "비밀번호가 일치하지 않습니다.")

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
