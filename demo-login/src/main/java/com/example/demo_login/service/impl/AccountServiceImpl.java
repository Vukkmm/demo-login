package com.example.demo_login.service.impl;

import com.example.demo_login.entity.login.Account;
import com.example.demo_login.repository.AccountRepository;
import com.example.demo_login.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public Account save(String username, String password) {
        log.info("(save) username : {}, password : {}",username, password);
        Account account = new Account(username, passwordEncoder.encode(password));
        return accountRepository.save(account);
    }

    @Transactional
    @Override
    public void update(String id, String username, String password) {
        log.info("update id : {}, username : {}, password : {}", id, username, password);
        accountRepository.update(id , username, passwordEncoder.encode(password));
    }

}
