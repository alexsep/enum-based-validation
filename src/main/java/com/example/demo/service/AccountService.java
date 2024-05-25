package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountType;
import com.example.demo.service.validator.AccountValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class AccountService {

    @Autowired
    private AccountValidatorFactory accountValidatorFactory;

    public Account createAccount(String customerId,
                                 AccountType type,
                                 BigDecimal initialBalance) {
        var account = new Account(type, customerId, initialBalance, OffsetDateTime.now());
        this.accountValidatorFactory
                .getAccountValidator(type)
                .validate(account);

        return account;

    }
}
