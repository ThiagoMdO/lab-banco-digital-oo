package com.dio.challenge.lab_banco_digital_oo.repository;

import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientBank, Long> {
}
