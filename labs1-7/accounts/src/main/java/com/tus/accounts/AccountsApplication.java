package com.tus.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties; // Lab 12
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; // Lab 7

import com.tus.accounts.dto.AccountsContactInfoDto; // Lab 12

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl") // Lab 7
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class}) // Lab 12
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
