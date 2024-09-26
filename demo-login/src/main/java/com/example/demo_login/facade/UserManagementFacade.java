package com.example.demo_login.facade;

import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.UserFacadeResponse;
import com.example.demo_login.dto.response.UserResponse;

import java.util.List;

public interface UserManagementFacade {
    UserFacadeResponse createUser(UserRequest request);

    List<UserFacadeResponse> getList();

    UserFacadeResponse getDetail(String id);
}
