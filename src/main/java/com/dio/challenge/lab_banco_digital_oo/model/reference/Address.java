package com.dio.challenge.lab_banco_digital_oo.model.reference;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer number;

    private String street;

    private String neighborhood;

    private String state;

    private String country;
}
