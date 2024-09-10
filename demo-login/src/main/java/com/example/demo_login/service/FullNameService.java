package com.example.demo_login.service;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.entity.login.FullName;

public interface FullNameService {
    FullName save(FullNameRequest request);
}
