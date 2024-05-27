package com.dio.challenge.lab_banco_digital_oo.controller;

import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequest;
import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequestToUpdate;
import com.dio.challenge.lab_banco_digital_oo.model.responses.AccountResponse;
import com.dio.challenge.lab_banco_digital_oo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    ResponseEntity<List<AccountResponse>> getAllAccounts(){
        List<AccountResponse> listAccounts = accountService.getAll();
        return ResponseEntity.ok().body(listAccounts);
    }

    @GetMapping("/{id}")
    ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id){
        AccountResponse response = accountService.getAccountById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}/listAccounts")
    ResponseEntity<List<AccountResponse>> getAllAccountsFromOneAccount(@PathVariable Long id){
        List<AccountResponse> listTypeAccounts = accountService.getAllAccountsByOne(id);
        return ResponseEntity.ok().body(listTypeAccounts);
    }

    @PostMapping
    ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request){
        AccountResponse response = accountService.create(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    ResponseEntity<AccountResponse> updateAccount(@PathVariable Long id, @RequestBody AccountRequestToUpdate typeAccount){
       AccountResponse response = accountService.update(id, typeAccount);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/cancel/{id}")
    ResponseEntity<Void> cancelAccount(@PathVariable Long id){
        accountService.cancel(id);
        return ResponseEntity.noContent().build();
    }
}
