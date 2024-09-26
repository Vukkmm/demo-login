package com.example.demo_login.facade.impl;


import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.*;
import com.example.demo_login.facade.UserManagementFacade;
import com.example.demo_login.service.AccountService;
import com.example.demo_login.service.AddressService;
import com.example.demo_login.service.FullNameService;
import com.example.demo_login.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementFacadeImpl implements UserManagementFacade {
    private final AccountService accountService;
    private final AddressService addressService;
    private final FullNameService fullNameService;
    private final UserService userService;


    @Transactional
    @Override
    public UserFacadeResponse createUser(UserRequest request) {
        log.info("(create) request : {}", request);
        AccountResponse accountResponse = accountService.create(request.getUsername(), request.getPassword());
        AddressResponse addressResponse = addressService.create(request.getProvince(), request.getDistrict(),request.getWard());
        FullNameResponse fullNameResponse = fullNameService.create(request.getFirstName(),request.getLastName());
        UserResponse userResponse = userService.create(
                request.getEmail(),
                request.getPhoneNumber(),
                accountResponse.getId(),
                addressResponse.getId(),
                fullNameResponse.getId());

        return new UserFacadeResponse(
                userResponse.getId(),
                userResponse.getEmail(),
                userResponse.getPhoneNumber(),
                userResponse.getAccountId(),
                userResponse.getAddressId(),
                userResponse.getFullNameId(),
                accountResponse,
                addressResponse,
                fullNameResponse
        );

    }

    @Override
    public List<UserFacadeResponse> getList() {
        log.info("(getList)");
        List<UserResponse> listUser = userService.getList();
        List<UserFacadeResponse> list = new ArrayList<>();
        for (UserResponse i : listUser
             ) {
            AccountResponse accountResponse = accountService.detail(i.getAccountId());
            AddressResponse addressResponse = addressService.detail(i.getAddressId());
            FullNameResponse fullNameResponse = fullNameService.detail(i.getFullNameId());
            UserFacadeResponse response = set(i, accountResponse, addressResponse, fullNameResponse);
            list.add(response);
        }
        return list;
    }

    private UserFacadeResponse set(UserResponse userResponse,
                                   AccountResponse accountResponse,
                                   AddressResponse addressResponse,
                                   FullNameResponse fullNameResponse) {
        return new UserFacadeResponse(
                userResponse.getId(),
                userResponse.getEmail(),
                userResponse.getPhoneNumber(),
                userResponse.getAccountId(),
                userResponse.getAddressId(),
                userResponse.getFullNameId(),
                accountResponse,
                addressResponse,
                fullNameResponse);
    }


}
