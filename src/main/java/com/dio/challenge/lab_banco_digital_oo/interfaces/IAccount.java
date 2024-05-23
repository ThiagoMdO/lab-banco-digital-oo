package com.dio.challenge.lab_banco_digital_oo.interfaces;

import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;

public interface IAccount {

    void withdraw(Double valueToWithdraw);

    void deposit(Double valueToDeposit);

    void transferToAnotherAccount(Double amountToTransfer, AccountDTO targetAccount);

}
