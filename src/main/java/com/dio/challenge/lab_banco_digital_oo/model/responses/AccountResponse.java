package com.dio.challenge.lab_banco_digital_oo.model.responses;

import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.model.reference.ClientBankPersist;
import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequest;
import lombok.ToString;

@ToString
public class AccountResponse extends AccountDTO {

    public AccountResponse(Account account){
        setId(account.getId());
        setClient(new ClientBankPersist(account.getClient()));
        setTypeAccount(account.getTypeAccount());
        setAgency(account.getAgency());
        setNumberAccount(account.getNumberAccount());
        setBalance(account.getBalance());
        setBank(account.getBank());
    }

    public AccountResponse(AccountRequest request){
        setTypeAccount(request.getTypeAccount());
        setAgency(request.getAgency());
        setNumberAccount(request.getNumberAccount());
        setBalance(request.getBalance());
    }
}
