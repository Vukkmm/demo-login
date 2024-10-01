package com.example.demo_login.service;

import com.example.demo_login.dto.request.RoleRequest;
import com.example.demo_login.dto.response.RoleResponse;
import com.example.demo_login.entity.login.Role;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    List<RoleResponse> getList();

}
