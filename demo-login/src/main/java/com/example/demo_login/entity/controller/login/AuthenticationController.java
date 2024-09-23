package com.example.demo_login.entity.controller.login;


import com.example.demo_login.dto.base.ResponseGeneral;
import com.example.demo_login.dto.request.AuthenticationRequest;
import com.example.demo_login.dto.response.AuthenticationResponse;
import com.example.demo_login.message.MessageService;
import com.example.demo_login.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo_login.constant.CommonConstant.DEFAULT_LANGUAGE;
import static com.example.demo_login.constant.CommonConstant.LANGUAGE;
import static com.example.demo_login.constant.MessageCodeConstant.CREATE_TOKEN;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final MessageService messageService;

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ResponseGeneral<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
            ) {
        log.info("(authenticate) request : {}", request);
        return ResponseGeneral.ofCreated(
                messageService.getMessage(CREATE_TOKEN, language),
                authenticationService.authentication(request));
    }

}
