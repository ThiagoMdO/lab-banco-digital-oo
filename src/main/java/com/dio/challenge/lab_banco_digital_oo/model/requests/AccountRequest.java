package com.dio.challenge.lab_banco_digital_oo.model.requests;

import lombok.*;

@NoArgsConstructor
@Data
public class AccountRequest {

    private Long client;

    private String typeAccount;

    private String agency;

    private String numberAccount;

    private Double balance;

    private Long bank;

}
