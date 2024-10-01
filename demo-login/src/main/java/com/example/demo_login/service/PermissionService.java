package com.example.demo_login.service;

import com.example.demo_login.dto.request.PermissionRequest;
import com.example.demo_login.dto.response.PermissionResponse;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

}
