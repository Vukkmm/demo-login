package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.NotFoundException;


import static com.example.demo_login.constant.ExceptionCode.ADDRESS_NOT_FOUND_EXCEPTION;

public class AddressNotFoundException extends NotFoundException {
    public AddressNotFoundException() {setCode(ADDRESS_NOT_FOUND_EXCEPTION);};
}
