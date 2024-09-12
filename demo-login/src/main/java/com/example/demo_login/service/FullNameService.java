package com.example.demo_login.service;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.entity.login.FullName;

public interface FullNameService {
    FullName save(FullNameRequest request);

    void UpdateByIndex(FullNameRequest fullNameRequest);

    FullNameResponse detail(String id);
}
