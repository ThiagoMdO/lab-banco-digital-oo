package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;

import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import org.springframework.http.HttpStatus;

public class BankNotFoundException extends StandardCustomException{
    public BankNotFoundException() {
        super(ErrorCode.BANK_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
