package com.example.demo_login.service;

import com.example.demo_login.dto.request.AuthenticationRequest;
import com.example.demo_login.dto.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse authentication(AuthenticationRequest request);
}
