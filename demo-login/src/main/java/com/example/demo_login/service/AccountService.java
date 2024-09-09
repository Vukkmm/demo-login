package com.example.demo_login.service;

import com.example.demo_login.entity.login.Account;

public interface AccountService {
    Account save(String username, String password);
}
