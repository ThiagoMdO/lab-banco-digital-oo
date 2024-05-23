package com.dio.challenge.lab_banco_digital_oo.model.reference;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClientBankPersist {

    private String id;

    private String name;
}
