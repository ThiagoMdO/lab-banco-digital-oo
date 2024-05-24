package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;

import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistsException extends StandardCustomException{

    public AccountAlreadyExistsException() {
        super(ErrorCode.ACCOUNT_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
    }
}
