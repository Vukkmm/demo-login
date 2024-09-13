package com.example.demo_login.service;

import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.UserResponse;

public interface UserService {
    UserResponse create(String accountNumber,
                        String email,
                        String phoneNumber,
                        String accountId,
                        String addressId,
                        String fullNameId);

}
