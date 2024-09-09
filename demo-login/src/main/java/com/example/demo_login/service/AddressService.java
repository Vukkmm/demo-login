package com.example.demo_login.service;

import com.example.demo_login.dto.request.AddressRequest;
import com.example.demo_login.entity.login.Address;


public interface AddressService {
    Address save(AddressRequest addressRequest);



}
