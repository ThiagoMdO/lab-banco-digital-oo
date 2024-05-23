package com.dio.challenge.lab_banco_digital_oo.model.entities.users;

import com.dio.challenge.lab_banco_digital_oo.model.reference.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Entity
@Getter
@NoArgsConstructor
public class ClientBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
    private String name;

//    @Embedded
    private Address address;

//    @NotNull
    private LocalDate birthDate;


}
