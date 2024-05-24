package com.dio.challenge.lab_banco_digital_oo.repository;

import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByNumberAccount(String numberAccount);

    List<Account> findByClient(ClientBank clientBank);
}
