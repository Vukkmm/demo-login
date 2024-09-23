package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.AccountRequest;
import com.example.demo_login.dto.response.AccountInformationBasic;
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

import java.util.HashSet;

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

//    @Override
//    public void update(String id, AccountRequest accountRequest) {
//        log.info("update id : {}, accountRequest : {}", id, accountRequest);
//        accountRepository.update(id , accountRequest.getUsername(), accountRequest.getPassword());
//    }
//
//
//    @Override
//    public Account findUserByUsername(String username) {
//        return accountRepository.findAccountByUsername(username);
//    }
//
////    @Override
////    public AccountInformationBasic findAccountByUserId(String id) {
////        return accountRepository.findByUserId(id);
////    }
//
//    @Override
//    public AccountResponse detail(String id) {
//        log.info("(detail) id : {}", id);
//        this.find(id);
//        return accountRepository.detail(id);
//    }
//
//    private Account find(String id) {
//        log.debug("(find) {}", id);
//        Account account = accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
//        if(account.isDeleted()) {
//            throw new AccountNotFoundException();
//        }
//        return account;
//    }


}
