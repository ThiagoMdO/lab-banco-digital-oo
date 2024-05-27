package com.dio.challenge.lab_banco_digital_oo.controller;

import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequestWithdrawAndDeposit;
import com.dio.challenge.lab_banco_digital_oo.model.responses.AccountResponse;
import com.dio.challenge.lab_banco_digital_oo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/actions")
public class AccountActionsController {

    @Autowired
    AccountService accountService;

    @PutMapping("{id}/withdraw")
    ResponseEntity<AccountResponse> withdraw(@PathVariable Long id, @RequestBody AccountRequestWithdrawAndDeposit amount){
        AccountResponse accountResponse = accountService.withdraw(id, amount);
        return ResponseEntity.ok().body(accountResponse);
    }
}
