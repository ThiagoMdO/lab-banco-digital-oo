package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;


import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class StandardCustomException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final String messageErrorCode;

    private final HttpStatus httpStatus;

    public StandardCustomException(ErrorCode errorCode, HttpStatus httpStatus){
        this.messageErrorCode = errorCode.getMessage();
        this.httpStatus = httpStatus;
    }
}
