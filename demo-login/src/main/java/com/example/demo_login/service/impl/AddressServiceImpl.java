package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.AddressRequest;
import com.example.demo_login.entity.login.Address;
import com.example.demo_login.repository.AddressRepository;
import com.example.demo_login.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Override
    public Address save(AddressRequest addressRequest) {
        return addressRepository.save(
                new Address(
                addressRequest.getProvince(),
                addressRequest.getDistrict(),
                addressRequest.getWard()));
    }


}
