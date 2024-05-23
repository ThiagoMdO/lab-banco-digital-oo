package com.dio.challenge.lab_banco_digital_oo.exception.build;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class Problem {

    private final Integer code;

    private final String status;

    private final String message;

    public Problem(String message, HttpStatus httpStatus){
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public Problem(HttpStatus httpStatus){
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = ErrorCode.SYSTEM_ERROR.getMessage();
    }

}
