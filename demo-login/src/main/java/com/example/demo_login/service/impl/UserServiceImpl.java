package com.example.demo_login.service.impl;

import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.User;
import com.example.demo_login.mapper.UserMapper;
import com.example.demo_login.repository.UserRepository;
import com.example.demo_login.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponse create(String email,
                               String phoneNumber,
                               String accountId,
                               String addressId,
                               String fullNameId
                               ) {
        log.info("(create) email : {}, " +
                "phoneNumber : {}, accountId : {}, " +
                "addressId : {}, fullName : {}" ,
                email, phoneNumber, accountId, accountId, fullNameId);
        User user = new User(email,phoneNumber,accountId,addressId,fullNameId);
        userRepository.save(user);
        return getUserResponse(user);
    }

    @Override
    public List<UserResponse> getList() {
        log.info("(getList)");
        List<User> list = userRepository.findAll();
        List<UserResponse> listResponse = new ArrayList<>();
        for (User user : list
             ) {
            UserResponse response = userMapper.toUserResponse(user);
            listResponse.add(response);
        }
        return listResponse;
    }

    private UserResponse getUserResponse(User user) {
        log.debug("(getUserResponse) user : {}", user);
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAccountId(),
                user.getAddressId(),
                user.getFullNameId()
        );
    }
}
