package com.example.demo_login.facade;

import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.UserFacadeResponse;
import com.example.demo_login.dto.response.UserResponse;

public interface UserManagementFacade {
    UserFacadeResponse createUser(UserRequest request);
}
