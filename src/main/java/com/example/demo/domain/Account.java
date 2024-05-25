package com.example.demo.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Account {

    private final String id;
    private final String customerId;
    private final AccountType type;
    private BigDecimal balance;
    private final OffsetDateTime openedAt;

    public Account(AccountType type, String customerId, BigDecimal balance, OffsetDateTime openedAt) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
        this.openedAt = openedAt;
    }

    public Account deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
        return this;
    }

    public String getId() {
        return id;
    }

    public AccountType getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    public OffsetDateTime getOpenedAt() {
        return openedAt;
    }


    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", openedAt=" + openedAt +
                '}';
    }
}
