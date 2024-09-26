package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.AuthenticationRequest;
import com.example.demo_login.dto.request.IntrospectRequest;
import com.example.demo_login.dto.response.AuthenticationResponse;
import com.example.demo_login.dto.response.IntrospectResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.exception.login.AccountNotFoundException;
import com.example.demo_login.exception.login.AccountUnauthenticatedException;
import com.example.demo_login.repository.AccountRepository;
import com.example.demo_login.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    @Transactional
    @Override
    public AuthenticationResponse createToken(AuthenticationRequest request) {
        log.info("(authentication) request : {}", request);

        var account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(AccountNotFoundException::new);

        boolean authenticated = passwordEncoder.matches(request.getPassword(), account.getPassword());

        if (!authenticated)
            throw new AccountUnauthenticatedException();

        var token = generateToke(account);
        return AuthenticationResponse.builder()
                .token(token)
                .authentication(true)
                .build();
    }

    @Override
    public IntrospectResponse verifyToken(IntrospectRequest request)
            throws JOSEException, ParseException {
        log.info("Verifying Token: {}",request);
        var token = request.getToken();

        // chuyen  hoa ve dang byte roi MACVerifier se verify nó
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        // phan tach thanh 3 phan header,payload, sign de co the access tu ben ngoai
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }

    private String generateToke(Account account) {
        log.warn("(generateToken) account : {}", account);
        JWSHeader header =new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(account.getUsername())
                .issuer("vuvuive.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(2, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("cannot create token");
            throw new RuntimeException(e);
        }
    }
}
