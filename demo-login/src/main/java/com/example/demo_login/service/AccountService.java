package com.example.demo_login.service;

import com.example.demo_login.dto.response.AccountInformationBasic;
import com.example.demo_login.entity.login.Account;

public interface AccountService {
    Account save(String username, String password);

    void  update(String id, String username, String password);

    Account findUserByUsername(String username);

    AccountInformationBasic findAccountByUserId(String id);
}
