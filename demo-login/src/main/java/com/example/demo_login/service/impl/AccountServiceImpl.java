package com.example.demo_login.service.impl;


import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.enums.Role;
import com.example.demo_login.exception.login.AccountNotFoundException;
import com.example.demo_login.repository.AccountRepository;
import com.example.demo_login.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;



    @Transactional
    @Override
    public AccountResponse create(String username, String password) {
        log.info("(create) username : {}, password : {}",username, password);
        Account account = new Account(username, passwordEncoder.encode(password));
        account.setRoles(Role.USER.name());
        accountRepository.save(account);
        return new AccountResponse(account.getId(), account.getUsername(), account.getPassword(),account.getRoles());
    }

    @Override
    public List<AccountResponse> getList() {
        log.info("(getList)");
        List<Account> list = accountRepository.findAll();
        List<AccountResponse> listResponse = new ArrayList<>();
        for (Account account : list
        ) {
            AccountResponse response = getAccountResponse(account);
            listResponse.add(response);
        }
        return listResponse;
    }

    @Override
    public AccountResponse detail(String id) {
        log.info("(detail) id : {}", id);
        this.find(id);
        return accountRepository.detail(id);
    }

    @Override
    public AccountResponse getByUsername(String username) {
        log.info("(getByUsername) username : {}", username);
        Account account = accountRepository.findAccountByUsername(username);
        return getAccountResponse(account);
    }

    @Transactional
    @Override
    public AccountResponse updateAccount(String id, String username, String password) {
        log.info("(updateAccount) id : {}, username : {}, password : {}",
                id, username, password);
        Account account = find(id);
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        accountRepository.save(account);

        return getAccountResponse(account);
    }

    private Account find(String id) {
        log.debug("(find) {}", id);
        Account account = accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        if(account.isDeleted()) {
            throw new AccountNotFoundException();
        }
        return  account;
    }

    private AccountResponse getAccountResponse(Account account) {
        log.debug("(getAccountResponse) account : {}", account);
        return new AccountResponse(
                account.getId(),
                account.getUsername(),
                account.getPassword(),
                account.getRoles()
        );
    }


}
