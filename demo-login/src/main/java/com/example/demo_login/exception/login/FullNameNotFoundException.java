package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.NotFoundException;

import static com.example.demo_login.constant.ExceptionCode.FULLNAME_NOT_FOUND_EXCEPTION;


public class FullNameNotFoundException extends NotFoundException {
    public FullNameNotFoundException() {setCode(FULLNAME_NOT_FOUND_EXCEPTION);};
}
