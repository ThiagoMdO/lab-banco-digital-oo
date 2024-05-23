package com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount;

public class CurrentAccount extends AccountDTO {
    private Double taxTransfer;

    public CurrentAccount(){
        taxTransfer = 0.01;
    }

    @Override
    public void withdraw(Double valueToWithdraw) {

    }

}
