package com.example.demo;

import com.example.demo.domain.AccountType;
import com.example.demo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class EnumBasedValidationApplication {


    public static void main(String[] args) {
        SpringApplication.run(EnumBasedValidationApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService) {
        return args -> {
            System.out.println(accountService.createAccount(UUID.randomUUID().toString(),
                    AccountType.SAVING,
                    BigDecimal.valueOf(50.55)));

            System.out.println(accountService.createAccount(UUID.randomUUID().toString(),
                    AccountType.CHECKING,
                    BigDecimal.valueOf(500)));
        };
    }


}
