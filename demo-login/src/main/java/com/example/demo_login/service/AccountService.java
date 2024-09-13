package com.example.demo_login.service;

import com.example.demo_login.dto.request.AccountRequest;
import com.example.demo_login.dto.response.AccountInformationBasic;
import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.entity.login.Account;

public interface AccountService {
    AccountResponse create(String username, String password);

    void  update(String id, AccountRequest accountRequest);

    Account findUserByUsername(String username);

    AccountInformationBasic findAccountByUserId(String id);

    AccountResponse detail(String id);
}
