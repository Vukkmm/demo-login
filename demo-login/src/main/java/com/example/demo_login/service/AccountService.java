package com.example.demo_login.service;

import com.example.demo_login.dto.request.AccountRequest;
import com.example.demo_login.dto.response.AccountInformationBasic;
import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.entity.login.User;

import java.util.List;

public interface AccountService {
    AccountResponse create(String username, String password);

    List<AccountResponse> getList();

    AccountResponse detail(String id);

    AccountResponse getByUsername(String username);

    AccountResponse updateAccount(String id , String username, String password);

//    void  update(String id, AccountRequest accountRequest);
//
//    Account findUserByUsername(String username);
//
//    AccountInformationBasic findAccountByUserId(String id);
//
//    AccountResponse detail(String id);
}
