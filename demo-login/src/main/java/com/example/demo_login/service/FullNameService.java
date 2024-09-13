package com.example.demo_login.service;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.entity.login.FullName;

public interface FullNameService {
    FullNameResponse create(String firstName, String lastName);

    void UpdateByIndex(String id, String firstName, String lastName);

    FullNameResponse detail(String id);
}
