package com.example.demo_login.mapper;

import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.entity.login.Address;
import com.example.demo_login.entity.login.FullName;
import com.example.demo_login.entity.login.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);

    AccountResponse toAccountResponse(Account account);

    AddressResponse toAddressResponse(Address address);

    FullNameResponse toFullNameResponse(FullName fullName);
}
