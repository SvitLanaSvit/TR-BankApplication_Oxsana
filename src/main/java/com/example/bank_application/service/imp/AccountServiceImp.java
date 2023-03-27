package com.example.bank_application.service.imp;

import com.example.bank_application.dto.AccountDto;
import com.example.bank_application.dto.AccountsListDto;

import com.example.bank_application.entity.enums.AccountStatus;
import com.example.bank_application.mapper.AccountMapper;
import com.example.bank_application.mapper.UuidMapper;
import com.example.bank_application.repository.AccountRepository;
import com.example.bank_application.service.AccountService;
import com.example.bank_application.service.exceptions.AccountNotFoundException;
import com.example.bank_application.service.exceptions.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountDto getAccountById(UUID id) {
//        log.info("Get product with id {}", id);
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException((ErrorMessage.ACCOUNT_NOT_FOUND))));
    }

    @Override
    public AccountsListDto getAllAccountsStatus() {
        return new AccountsListDto(accountMapper.accountsToDto(accountRepository.getAllByStatus(AccountStatus.ACTIVE)));
    }

}
