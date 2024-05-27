package com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount;

import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class SavingsAccount extends AccountDTO {

    public SavingsAccount(Account account){
        super(account);
    }
}
