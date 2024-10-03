package com.example.demo_login.config;

import com.example.demo_login.entity.login.Account;
import com.example.demo_login.entity.login.Role;
import com.example.demo_login.enums.RoleUser;
import com.example.demo_login.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationInitConfig {

    private final PasswordEncoder passwordEncoder;


    @Bean
    ApplicationRunner applicationRunner(AccountRepository accountRepository
    ) {
        return args -> {
            if(accountRepository.findByUsername("admin").isEmpty()) {
                Set<String> roles = new HashSet<>();
                roles.add(RoleUser.ADMIN.name());
                Account account = Account.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("adminService"))
                        .roles(roles)
                        .build();

                accountRepository.save(account);
                log.warn("admin user been created with default password: admin, please change");

            }
        };
    }
}
