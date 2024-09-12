package com.example.demo_login.facade.impl;

import com.example.demo_login.facade.UserManagementFacade;
import com.example.demo_login.service.AccountService;
import com.example.demo_login.service.AddressService;
import com.example.demo_login.service.FullNameService;
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


}
