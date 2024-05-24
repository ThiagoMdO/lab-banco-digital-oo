package com.dio.challenge.lab_banco_digital_oo.model.reference;

import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClientBankPersist {

    @Id
    private Long id;

    private String name;

    public ClientBankPersist(ClientBank clientBank){
        id = clientBank.getId();
        name = clientBank.getName();
    }
}
