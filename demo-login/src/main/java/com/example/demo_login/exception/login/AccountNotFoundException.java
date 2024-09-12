package com.example.demo_login.exception.login;

import com.example.demo_login.exception.base.NotFoundException;

import static com.example.demo_login.constant.ExceptionCode.ACCOUNT_NOT_FOUND_EXCEPTION;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException() {setCode(ACCOUNT_NOT_FOUND_EXCEPTION);};
}
