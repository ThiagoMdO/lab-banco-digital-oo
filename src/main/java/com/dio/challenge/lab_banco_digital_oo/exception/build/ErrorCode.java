package com.dio.challenge.lab_banco_digital_oo.exception.build;

public enum ErrorCode {

    NOT_FOUND("Data not found"),

    BANK_NOT_FOUND("Bank not found"),

    CLIENT_NOT_FOUND("Client not found"),

    BAD_REQUEST("Invalid data"),

    SYSTEM_ERROR("Unavailable server"),

    INSUFFICIENT_FUNDS("You don't have enough funds to this operation"),

    ACCOUNT_ALREADY_EXISTS("This account number belongs to another account"),

    EMPTY_LIST("The list is empty");

    private final String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
