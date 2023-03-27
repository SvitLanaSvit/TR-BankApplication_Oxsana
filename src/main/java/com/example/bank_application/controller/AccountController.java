package com.example.bank_application.controller;

import com.example.bank_application.dto.AccountDto;
import com.example.bank_application.dto.AccountsListDto;
import com.example.bank_application.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public AccountsListDto getAllAccounts() {
        return accountService.getAllAccountsStatus();
    }
}
