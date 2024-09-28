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
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

        return set(userResponse, accountResponse,addressResponse, fullNameResponse);

    }

    @PreAuthorize("hasRole('ADMIN')") // CHECK BEFORE CALL METHOD 
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

//    @PostAuthorize("hasRole('ADMIN')") // CHECK AFTER CALL METHOD
    @PostAuthorize("returnObject.username == authentication.name") // CHECK AFTER CALL METHOD
    @Override
    public UserFacadeResponse getDetail(String id) {
        log.info("(getDetail) id : {}", id);
        UserResponse userResponse = userService.detail(id);
        AddressResponse addressResponse = addressService.detail(userResponse.getAddressId());
        AccountResponse accountResponse  = accountService.detail(userResponse.getAccountId());
        FullNameResponse fullNameResponse = fullNameService.detail(userResponse.getFullNameId());
        return set(userResponse, accountResponse, addressResponse, fullNameResponse);
    }

    @Override
    public UserFacadeResponse getMyInfo() {
        log.info("(getMyInfo)");
        var context =  SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        AccountResponse accountResponse = accountService.getByUsername(name);
        UserResponse userResponse = userService.getByAccountId(accountResponse.getId());
        AddressResponse addressResponse = addressService.detail(userResponse.getAddressId());
        FullNameResponse fullNameResponse = fullNameService.detail(userResponse.getFullNameId());

        return set(userResponse, accountResponse, addressResponse, fullNameResponse);
    }

    @Transactional
    @Override
    public UserFacadeResponse update(String id, UserRequest request) {
        log.info("(update) request : {}", request);

        UserResponse userResponse = userService.updateUser(id, request.getEmail(), request.getPhoneNumber());
        AccountResponse accountResponse = accountService.updateAccount(
                                        userResponse.getAccountId(),
                                        request.getUsername(),
                                        request.getPassword());

        AddressResponse addressResponse = addressService.updateAddress(
                                        userResponse.getAddressId(),
                                        request.getProvince(),
                                        request.getDistrict(),
                                        request.getWard());

        FullNameResponse fullNameResponse = fullNameService.updateFullName(
                                        userResponse.getFullNameId(),
                                        request.getFirstName(),
                                        request.getLastName());

        return set(userResponse, accountResponse, addressResponse, fullNameResponse);
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
                accountResponse.getUsername(),
                accountResponse,
                addressResponse,
                fullNameResponse);
    }


}
