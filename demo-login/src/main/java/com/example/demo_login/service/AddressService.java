package com.example.demo_login.service;

import com.example.demo_login.dto.request.AddressRequest;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.entity.login.Address;

import java.util.List;


public interface AddressService {
    AddressResponse create(String province, String district, String ward);

    List<Address> saveAll(List<AddressRequest> addressList);

    AddressResponse detail(String id);
}
