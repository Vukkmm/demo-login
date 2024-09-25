package com.example.demo_login.service;

import com.example.demo_login.dto.request.AuthenticationRequest;
import com.example.demo_login.dto.request.IntrospectRequest;
import com.example.demo_login.dto.response.AuthenticationResponse;
import com.example.demo_login.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse createToken(AuthenticationRequest request);

    IntrospectResponse verifyToken(IntrospectRequest request) throws JOSEException, ParseException;
}
