package com.dio.challenge.lab_banco_digital_oo.repository;

import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
