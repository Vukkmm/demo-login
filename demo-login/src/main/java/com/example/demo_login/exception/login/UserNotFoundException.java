package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.BadRequestException;

import static com.example.demo_login.constant.ExceptionCode.USER_NOT_FOUND_EXCEPTION;

public class UserNotFoundException extends BadRequestException {
    public UserNotFoundException() {
        setCode(USER_NOT_FOUND_EXCEPTION);
    }
}
