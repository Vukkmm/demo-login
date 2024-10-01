package com.example.demo_login.service;

import com.example.demo_login.dto.request.PermissionRequest;
import com.example.demo_login.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getList();

    void delete(String name);

}
