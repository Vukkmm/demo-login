package com.example.demo_login.service;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.entity.login.FullName;

import java.util.List;

public interface FullNameService {
    FullNameResponse create(String firstName, String lastName);

    List<FullNameResponse> getList();

    void UpdateByIndex(String id, String firstName, String lastName);

    FullNameResponse detail(String id);

    FullNameResponse updateFullName(String id, String firstName, String lastName);
}
