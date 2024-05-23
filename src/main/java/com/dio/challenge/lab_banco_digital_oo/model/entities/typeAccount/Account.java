package com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount;

import com.dio.challenge.lab_banco_digital_oo.interfaces.IAccount;
import com.dio.challenge.lab_banco_digital_oo.model.reference.ClientBankPersist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Accounts")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ClientBankPersist client;

//    @NotNull
    private String typeAccount;

//    @NotNull
    private String agency;

//    @NotNull
    private String numberAccount;

    private Double balance;

}
