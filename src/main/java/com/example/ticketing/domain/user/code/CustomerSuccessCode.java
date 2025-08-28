package com.example.ticketing.domain.user.code;

import com.example.ticketing.common.code.success.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomerSuccessCode implements BaseSuccessCode {
    // 인증 관련
    LOGIN_SUCCESS(HttpStatus.OK, "AUTH200", "로그인에 성공했습니다."),
    LOGOUT_SUCCESS(HttpStatus.OK, "AUTH201", "로그아웃에 성공했습니다."),

    // 회원 관련
    SIGNUP_SUCCESS(HttpStatus.CREATED, "CUSTOMER201", "회원가입에 성공했습니다."),
    CUSTOMER_INFO_RETRIEVED(HttpStatus.OK, "CUSTOMER200", "회원 정보를 성공적으로 조회했습니다."),
    CUSTOMER_UPDATED(HttpStatus.OK, "CUSTOMER204", "회원 정보가 성공적으로 수정되었습니다."),
    CUSTOMER_DELETED(HttpStatus.OK, "CUSTOMER205", "회원 탈퇴가 성공적으로 처리되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
