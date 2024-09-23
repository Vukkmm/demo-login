package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.BadRequestException;


import static com.example.demo_login.constant.ExceptionCode.ACCOUNT_AUTHENTICATED_EXCEPTION;

public class AccountUnauthenticatedException extends BadRequestException {
    public AccountUnauthenticatedException() {setCode(ACCOUNT_AUTHENTICATED_EXCEPTION);};
}
