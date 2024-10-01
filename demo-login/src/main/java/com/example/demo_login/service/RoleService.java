package com.example.demo_login.service;

import com.example.demo_login.dto.request.RoleRequest;
import com.example.demo_login.dto.response.RoleResponse;

public interface RoleService {

    RoleResponse create(RoleRequest request);

}
