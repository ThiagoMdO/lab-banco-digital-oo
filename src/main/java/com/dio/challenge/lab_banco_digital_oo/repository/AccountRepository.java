package com.dio.challenge.lab_banco_digital_oo.repository;

import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
