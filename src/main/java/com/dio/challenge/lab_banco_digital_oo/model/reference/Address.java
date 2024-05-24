package com.dio.challenge.lab_banco_digital_oo.model.reference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @JsonIgnore
    private Long id;

    private Integer number;

    private String street;

    private String neighborhood;

    private String city;

    private String state;

    private String country;
}
