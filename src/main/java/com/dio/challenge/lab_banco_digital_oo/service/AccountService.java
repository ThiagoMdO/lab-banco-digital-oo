package com.dio.challenge.lab_banco_digital_oo.service;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.EmptyListException;
import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public <T extends AccountDTO> List<T> getAll(){
        List<Account> list = accountRepository.findAll();

        if (list.isEmpty())
            throw new EmptyListException();
        return list.stream()
                .map(a -> AccountDTO.convertTypeAccountDTO(T, a)).collect(Collectors.toList());
    }

    //Olhar abstração do tipo Generico
    //Ollhar persistir entitys com atributos como outras classes, fazer com que apenas um valor seja armazenado

}
