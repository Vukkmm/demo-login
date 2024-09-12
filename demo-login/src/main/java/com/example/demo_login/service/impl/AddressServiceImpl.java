package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.AddressRequest;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.entity.login.Address;
import com.example.demo_login.exception.login.AccountNotFoundException;
import com.example.demo_login.exception.login.AddressNotFoundException;
import com.example.demo_login.repository.AddressRepository;
import com.example.demo_login.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public Address save(AddressRequest addressRequest) {
        log.info("(save) addressRequest:{}", addressRequest);
        return addressRepository.save(
                new Address(
                addressRequest.getProvince(),
                addressRequest.getDistrict(),
                addressRequest.getWard()));
    }

    @Transactional
    @Override
    public List<Address> saveAll(List<AddressRequest> addressList) {
        log.info("(saveAll) addressList:{}", addressList);
        List<Address> addresses = new ArrayList<>();
        for (AddressRequest i: addressList
             ) {
            addresses.add(new Address(i.getProvince(),
                    i.getDistrict(),
                    i.getWard()));
        }
        return addressRepository.saveAll(addresses);
    }

    @Override
    public AddressResponse detail(String id) {
        log.info("(detail) id : {}", id);
        this.find(id);
        return addressRepository.detail(id);
    }

    private Address find(String id) {
        log.debug("(find) {}", id);
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        if(address.isDeleted()) {
            throw new AccountNotFoundException();
        }
        return address;
    }




}
