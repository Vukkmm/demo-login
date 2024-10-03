package com.example.demo_login.service;

import com.example.demo_login.dto.response.AddressResponse;

import java.util.List;


public interface AddressService {
    AddressResponse create(String province, String district, String ward);

    List<AddressResponse> getList();

    AddressResponse detail(String id);

    AddressResponse updateAddress(String id, String province, String district, String ward);
}
