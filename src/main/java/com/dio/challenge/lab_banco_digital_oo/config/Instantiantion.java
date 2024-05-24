package com.dio.challenge.lab_banco_digital_oo.config;

import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import com.dio.challenge.lab_banco_digital_oo.model.reference.Address;
import com.dio.challenge.lab_banco_digital_oo.repository.AccountRepository;
import com.dio.challenge.lab_banco_digital_oo.repository.BankRepository;
import com.dio.challenge.lab_banco_digital_oo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiantion implements CommandLineRunner {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BankRepository bankRepository;

    @Override
    public void run(String... args) throws Exception {

        Bank bank1 = Bank.builder()
        .id(1L)
        .name("Banco do Brasil")
        .build();

        Bank bank2 = Bank.builder()
        .id(2L)
        .name("Caixa Economica")
        .build();

        bankRepository.saveAll(Arrays.asList(bank1, bank2));

        ClientBank clientBank1 = ClientBank.builder()
            .id(21L)
            .name("Jose")
            .address(
                Address.builder()
                .id(1L)
                .number(23)
                .street("Street 1")
                .neighborhood("Central")
                .city("Salvador")
                .state("BA")
                .country("Brazil")
                .build()
            )
            .birthDate(LocalDate.of(1998, 4, 8))
            .build();

        ClientBank clientBank2 = ClientBank.builder()
            .id(29L)
            .name("Rosana")
            .address(
                Address.builder()
                    .id(2L)
                    .number(44)
                    .street("Street 2")
                    .city("Feira de Santana")
                    .neighborhood("Central")
                    .state("BA")
                    .country("Brazil")
                    .build()
            )
            .birthDate(LocalDate.of(1988, 7, 8))
            .build();


        clientRepository.saveAll(Arrays.asList(clientBank1, clientBank2));

        Account acCc1 = Account.builder()
            .id(1L)
            .client(clientBank1)
            .typeAccount("CurrentAccount")
            .agency("7789")
            .numberAccount("00123")
            .balance(301.1)
            .bank(bank1)
            .build();

        Account acCc2 = Account.builder()
            .id(2L)
            .client(clientBank2)
            .typeAccount("SavingsAccount")
            .agency("7789")
            .numberAccount("00129")
            .balance(98201.1)
            .bank(bank1)
            .build();

        Account acCc3 = Account.builder()
            .id(3L)
            .client(clientBank2)
            .typeAccount("CurrentAccount")
            .agency("7789")
            .numberAccount("00228")
            .balance(1000.1)
            .bank(bank1)
            .build();

        accountRepository.saveAll(Arrays.asList(acCc1, acCc2, acCc3));




    }
}
