package com.example.demo_login.controller.login;


import com.example.demo_login.dto.base.ResponseGeneral;
import com.example.demo_login.dto.request.AuthenticationRequest;
import com.example.demo_login.dto.request.IntrospectRequest;
import com.example.demo_login.dto.response.AuthenticationResponse;
import com.example.demo_login.dto.response.IntrospectResponse;
import com.example.demo_login.message.MessageService;
import com.example.demo_login.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

import static com.example.demo_login.constant.CommonConstant.DEFAULT_LANGUAGE;
import static com.example.demo_login.constant.CommonConstant.LANGUAGE;
import static com.example.demo_login.constant.MessageCodeConstant.CREATE_TOKEN;
import static com.example.demo_login.constant.MessageCodeConstant.VERIFY_TOKEN;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final MessageService messageService;

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ResponseGeneral<AuthenticationResponse> createToken(
            @Valid @RequestBody AuthenticationRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
            ) {
        log.info("(createToken) request : {}", request);
        return ResponseGeneral.ofCreated(
                messageService.getMessage(CREATE_TOKEN, language),
                authenticationService.createToken(request));
    }

    @PostMapping("/introspect")
    public ResponseGeneral<IntrospectResponse> verifyToken(
            @Valid @RequestBody IntrospectRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) throws ParseException, JOSEException {
        log.info("(verifyToken) request : {}", request );
        return ResponseGeneral.ofCreated(
                messageService.getMessage(VERIFY_TOKEN, language),
                authenticationService.verifyToken(request)
        );
    }

}
