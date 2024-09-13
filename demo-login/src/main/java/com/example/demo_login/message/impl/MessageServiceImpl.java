package com.example.demo_login.message.impl;

import com.example.demo_login.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;
    @Override
    public String getMessage(String code, String language) {
        try {
            return messageSource.getMessage(code, null, new Locale(language));
        } catch (Exception ex) {
            return code;
        }
    }
}
