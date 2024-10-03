package com.example.demo_login.service;



import com.example.demo_login.dto.response.AccountResponse;




import java.util.List;

public interface AccountService {
    AccountResponse create(String username, String password);

    List<AccountResponse> getList();

    AccountResponse detail(String id);

    AccountResponse getByUsername(String username);

    AccountResponse updateAccount(String id , String username, String password);


}
