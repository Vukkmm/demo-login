package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.BadRequestException;

import static com.example.demo_login.constant.ExceptionCode.ROLE_NOT_FOUND_EXCEPTION;

public class RoleNotFoundException extends BadRequestException {
    public RoleNotFoundException() {
        setCode(ROLE_NOT_FOUND_EXCEPTION);
    }
}
