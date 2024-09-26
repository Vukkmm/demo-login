package com.example.demo_login.service;

import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.repository.UserRepository;

import java.util.List;

public interface UserService {
    UserResponse create(String email,
                        String phoneNumber,
                        String accountId,
                        String addressId,
                        String fullNameId);

    List<UserResponse> getList();

    UserResponse detail(String id);
}
