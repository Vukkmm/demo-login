package com.example.demo_login.exception.base;

import static com.example.demo_login.constant.ExceptionCode.BAD_REQUEST_CODE;
import static com.example.demo_login.exception.base.StatusConstants.BAD_REQUEST;

public class BadRequestException extends BaseException{
    public BadRequestException() {
        setCode(BAD_REQUEST_CODE);
        setStatus(BAD_REQUEST);
    }
}
