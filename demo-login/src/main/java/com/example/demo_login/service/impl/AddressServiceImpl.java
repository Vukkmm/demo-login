package com.example.demo_login.service.impl;


import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.entity.login.Address;
import com.example.demo_login.exception.login.AddressNotFoundException;
import com.example.demo_login.mapper.UserMapper;
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
    private final UserMapper mapper;

    @Transactional
    @Override
    public AddressResponse create(String province, String district, String ward) {
        log.info("(create) province : {}, district : {}, ward : {}", province, district, ward);
         Address address = new Address(province, district, ward);
         addressRepository.save(address);
         return new AddressResponse(
                 address.getId(),
                 address.getProvince(),
                 address.getDistrict(),
                 address.getWard());
    }

    @Override
    public List<AddressResponse> getList() {
        log.info("(getList)");
        List<Address> list = addressRepository.findAll();
        List<AddressResponse> listResponse = new ArrayList<>();
        for (Address i  : list
        ) {
            AddressResponse response = mapper.toAddressResponse(i);
            listResponse.add(response);
        }
        return listResponse;
    }



    @Override
    public AddressResponse detail(String id) {
        log.info("(detail) id : {}", id);
        this.find(id);
        return addressRepository.detail(id);
    }

    @Override
    public AddressResponse updateAddress(String id, String province, String district, String ward) {
        log.info("(updateAddress) id : {}, province : {}, district : {}, ward : {}",
                id, province, district, ward);
        Address address = find(id);
        address.setDistrict(district);
        address.setProvince(province);
        address.setWard(ward);
        addressRepository.save(address);

        return getAddressResponse(address);
    }

    private Address find(String id) {
        log.debug("(find) {}", id);
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        if(address.isDeleted()) {
            throw new AddressNotFoundException();
        }
        return  address;
    }

    private AddressResponse getAddressResponse(Address address) {
        log.debug("(getAddressResponse) address : {}", address);
        return new AddressResponse(
                address.getId(),
                address.getProvince(),
                address.getDistrict(),
                address.getWard()
        );
    }

}
