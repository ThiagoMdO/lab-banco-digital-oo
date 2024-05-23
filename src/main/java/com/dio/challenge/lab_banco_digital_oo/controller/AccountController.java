package com.dio.challenge.lab_banco_digital_oo.controller;

import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> listAccounts = accountService.getAll();
        return ResponseEntity.ok().body(listAccounts);
    }
}
