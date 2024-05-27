package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;

import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import org.springframework.http.HttpStatus;

public class TypeAccountIsNotAvailableException extends StandardCustomException{
    public TypeAccountIsNotAvailableException() {
        super(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }
}
