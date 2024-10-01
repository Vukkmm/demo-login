package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.BadRequestException;

import static com.example.demo_login.constant.ExceptionCode.PERMISSION_NOT_FOUND_EXCEPTION;

public class PermissionNotFoundException extends BadRequestException {
    public PermissionNotFoundException() {
        setCode(PERMISSION_NOT_FOUND_EXCEPTION);
    }
}
