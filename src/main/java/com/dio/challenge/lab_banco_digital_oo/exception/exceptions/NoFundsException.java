package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;

import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import org.springframework.http.HttpStatus;

public class NoFundsException extends StandardCustomException{

    public NoFundsException() {
        super(ErrorCode.INSUFFICIENT_FUNDS, HttpStatus.BAD_REQUEST);
    }
}
