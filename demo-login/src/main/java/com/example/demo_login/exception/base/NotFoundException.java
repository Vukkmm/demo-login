package com.example.demo_login.exception.base;

import static com.example.demo_login.constant.ExceptionCode.NOT_FOUND_CODE;

public class NotFoundException extends BaseException{
    public NotFoundException() {
        setCode(NOT_FOUND_CODE);
        setStatus(StatusConstants.NOT_FOUND);
    }
}
