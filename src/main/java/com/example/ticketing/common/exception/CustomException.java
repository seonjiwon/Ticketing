package com.example.ticketing.common.exception;

import com.example.ticketing.common.code.error.BaseErrorCode;
import lombok.Getter;


@Getter
public class CustomException extends RuntimeException{

    private final BaseErrorCode code;

    public CustomException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode;
    }
}
