package com.example.demo.service.validator;

import com.example.demo.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class AccountValidatorFactory {

    @Autowired
    private CheckingAccountValidatorImpl checkingAccountValidator;
    @Autowired
    private SavingAccountValidatorImpl savingAccountValidator;

    public AccountValidator getAccountValidator(AccountType accountType) {
        return switch (accountType) {
            case CHECKING -> checkingAccountValidator;
            case SAVING -> savingAccountValidator;
            case MONEY_MARKET, DEPOSIT_CERTIFICATES ->
                    throw new IllegalStateException("Validator has not been implemented for this account type: " + accountType);

        };
    }
}
