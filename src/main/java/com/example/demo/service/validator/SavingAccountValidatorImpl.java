package com.example.demo.service.validator;

import com.example.demo.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class SavingAccountValidatorImpl implements AccountValidator {
    @Override
    public void validate(Account account) {
        System.out.printf("validating account of the type %s%n", account.getType().toString());
    }
}
