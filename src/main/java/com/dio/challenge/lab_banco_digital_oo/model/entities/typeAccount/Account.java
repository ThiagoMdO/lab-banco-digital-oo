package com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount;

import com.dio.challenge.lab_banco_digital_oo.enuns.StatusAccount;
import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import com.dio.challenge.lab_banco_digital_oo.model.responses.AccountResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "account_tb")
@NoArgsConstructor
@AllArgsConstructor
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "foreign_client_id")
    private ClientBank client;

    @NotEmpty
    private String typeAccount;

    @Enumerated(EnumType.STRING)
    private StatusAccount statusAccount;

    @NotEmpty
    private String agency;

    @NotEmpty
    private String numberAccount;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Account(AccountDTO accountDTO, ClientBank clientBank, Bank bankDB){
        id = accountDTO.getId();
        client = clientBank;
        statusAccount = StatusAccount.ACTIVE;
        typeAccount = accountDTO.getTypeAccount();
        agency = accountDTO.getAgency();
        numberAccount = accountDTO.getNumberAccount();
        balance = accountDTO.getBalance();
        bank = bankDB;
    }

    public Account(AccountResponse toUpdate){
        id = toUpdate.getId();
        client = new ClientBank(toUpdate.getClient());
        typeAccount = toUpdate.getTypeAccount();
        agency = toUpdate.getAgency();
        numberAccount = toUpdate.getNumberAccount();
        balance = toUpdate.getBalance();
        bank = toUpdate.getBank();
    }
}
