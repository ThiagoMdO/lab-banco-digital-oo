package com.dio.challenge.lab_banco_digital_oo.exception.build;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.*;
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

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<Object> handlerEmptyListException(){
        StandardCustomException emptyListException = new EmptyListException();
        var problem = new Problem(emptyListException.getMessageErrorCode(), emptyListException.getHttpStatus());
        return ResponseEntity.status(emptyListException.getHttpStatus()).body(problem);
    }

    @ExceptionHandler(NoFoundAccountException.class)
    public ResponseEntity<Object> handlerNoFoundAccountException(){
        StandardCustomException noFoundAccountException = new NoFoundAccountException();
        var problem = new Problem(noFoundAccountException.getMessageErrorCode(), noFoundAccountException.getHttpStatus());
        return ResponseEntity.status(noFoundAccountException.getHttpStatus()).body(problem);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<Object> handlerAccountAlreadyExistsException(){
        StandardCustomException accountAlreadyExistsException = new AccountAlreadyExistsException();
        var problem = new Problem(accountAlreadyExistsException.getMessageErrorCode(), accountAlreadyExistsException.getHttpStatus());
        return ResponseEntity.status(accountAlreadyExistsException.getHttpStatus()).body(problem);
    }

    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<Object> handlerBankNotFoundException(){
        StandardCustomException bankNotFoundException = new BankNotFoundException();
        var problem = new Problem(bankNotFoundException.getMessageErrorCode(), bankNotFoundException.getHttpStatus());
        return ResponseEntity.status(bankNotFoundException.getHttpStatus()).body(problem);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> handlerClientNotFoundException(){
        StandardCustomException clientNotFoundException = new ClientNotFoundException();
        var problem = new Problem(clientNotFoundException.getMessageErrorCode(), clientNotFoundException.getHttpStatus());
        return ResponseEntity.status(clientNotFoundException.getHttpStatus()).body(problem);
    }
}
