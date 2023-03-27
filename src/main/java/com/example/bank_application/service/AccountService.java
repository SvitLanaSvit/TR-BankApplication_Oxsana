package com.example.bank_application.service;

import com.example.bank_application.dto.AccountDto;
import com.example.bank_application.dto.AccountsListDto;

import java.util.UUID;

public interface AccountService {

    AccountDto getAccountById(UUID id);

    AccountsListDto getAllAccountsStatus();
}
