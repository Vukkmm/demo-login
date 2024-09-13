package com.example.demo_login.facade.impl;


import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.facade.UserManagementFacade;
import com.example.demo_login.service.AccountService;
import com.example.demo_login.service.AddressService;
import com.example.demo_login.service.FullNameService;
import com.example.demo_login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementFacadeImpl implements UserManagementFacade {
    private final AccountService accountService;
    private final AddressService addressService;
    private final FullNameService fullNameService;
    private final UserService userService;


    @Override
    public UserResponse create(UserRequest request) {
        log.info("(create) request : {}", request);
        AccountResponse accountResponse = accountService.create(request.getUsername(), request.getPassword());
        AddressResponse addressResponse = addressService.create(request.getProvince(), request.getDistrict(),request.getWard());
        FullNameResponse fullNameResponse = fullNameService.create(request.getFirstName(),request.getLastName());
        UserResponse userResponse = userService.create(request.getAccountNumber(),
                request.getEmail(),
                request.getPhoneNumber(),
                accountResponse.getId(),
                addressResponse.getId(),
                fullNameResponse.getId());
        return userResponse;
    }


}
