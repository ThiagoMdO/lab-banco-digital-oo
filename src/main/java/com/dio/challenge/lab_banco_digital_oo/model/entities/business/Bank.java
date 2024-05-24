package com.dio.challenge.lab_banco_digital_oo.model.entities.business;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.NoFundsException;
import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity (name = "bank_tb")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Account> accounts;


    public static void checkBalanceAccountToWithdraw(AccountDTO account, Double amount){
        if (account.getBalance() < amount)
            throw new NoFundsException();
    }
}
