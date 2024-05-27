package com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount;

import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;

public class CurrentAccount extends AccountDTO {

    public CurrentAccount(Account account){
        super(account);
        taxTransfer = 0.01;
    }

    private final Double taxTransfer;

    public CurrentAccount(){
        taxTransfer = 0.01;
    }

    @Override
    public void withdraw(Double valueToWithdraw) {
        Bank.checkBalanceAccountToWithdrawForTax(this, valueToWithdraw, taxTransfer);
        setBalance(getBalance() - valueToWithdraw - (valueToWithdraw * taxTransfer));
    }

}
