package com.dio.challenge.lab_banco_digital_oo.exception.build;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.NoFundsException;
import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.StandardCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NoFundsException.class)
    public ResponseEntity<Object> handlerNoFundsException(){
        StandardCustomException noFundsException = new NoFundsException();
        var problem = new Problem(noFundsException.getMessageErrorCode(), noFundsException.getHttpStatus());
        return ResponseEntity.status(noFundsException.getHttpStatus()).body(problem);
    }
}
