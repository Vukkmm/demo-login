package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.User;
import com.example.demo_login.repository.UserRepository;
import com.example.demo_login.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse create(UserRequest request) {
        log.info("(create) request : {}", request);
        User user = new User(
                request.getAccountNumber(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAccountId(),
                request.getAddressId(),
                request.getFullNameId()
                );
        userRepository.save(user);
        return getUserResponse(user);
    }

    private UserResponse getUserResponse(User user) {
        log.debug("(getUserResponse) user : {}", user);
        return new UserResponse(
                user.getId(),
                user.getAccountNumber(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAccountId(),
                user.getAddressId(),
                user.getFullNameId());
    }
}
