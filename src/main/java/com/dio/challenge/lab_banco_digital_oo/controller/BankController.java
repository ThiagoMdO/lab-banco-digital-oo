package com.dio.challenge.lab_banco_digital_oo.controller;

import com.dio.challenge.lab_banco_digital_oo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/banks")
public class BankController {

    @Autowired
    BankService bankService;
//
//    @GetMapping
//    public ResponseEntity<Ban>
}
