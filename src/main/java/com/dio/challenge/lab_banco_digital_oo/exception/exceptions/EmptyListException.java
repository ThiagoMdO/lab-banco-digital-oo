package com.dio.challenge.lab_banco_digital_oo.exception.exceptions;

import com.dio.challenge.lab_banco_digital_oo.exception.build.ErrorCode;
import org.springframework.http.HttpStatus;

public class EmptyListException extends StandardCustomException{

    public EmptyListException() {
        super(ErrorCode.EMPTY_LIST, HttpStatus.OK);
    }
}
