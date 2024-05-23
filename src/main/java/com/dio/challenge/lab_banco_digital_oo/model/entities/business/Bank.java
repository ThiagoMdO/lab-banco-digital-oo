package com.dio.challenge.lab_banco_digital_oo.model.entities.business;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.NoFundsException;
import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

//    private List<AccountDTO> accountDTOS = new ArrayList<>();


    public static void checkBalanceAccountToWithdraw(AccountDTO account, Double amount){
        if (account.getBalance() < amount)
            throw new NoFundsException();
    }
}
