package com.example.demo_login.mapper;

import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.entity.login.Address;
import com.example.demo_login.entity.login.FullName;
import com.example.demo_login.entity.login.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T15:29:49+0700",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setPhoneNumber( user.getPhoneNumber() );
        userResponse.setAccountId( user.getAccountId() );
        userResponse.setAddressId( user.getAddressId() );
        userResponse.setFullNameId( user.getFullNameId() );

        return userResponse;
    }

    @Override
    public AccountResponse toAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId( account.getId() );
        accountResponse.setUsername( account.getUsername() );
        accountResponse.setPassword( account.getPassword() );

        return accountResponse;
    }

    @Override
    public AddressResponse toAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId( address.getId() );
        addressResponse.setProvince( address.getProvince() );
        addressResponse.setDistrict( address.getDistrict() );
        addressResponse.setWard( address.getWard() );

        return addressResponse;
    }

    @Override
    public FullNameResponse toFullNameResponse(FullName fullName) {
        if ( fullName == null ) {
            return null;
        }

        FullNameResponse fullNameResponse = new FullNameResponse();

        fullNameResponse.setId( fullName.getId() );
        fullNameResponse.setFirstName( fullName.getFirstName() );
        fullNameResponse.setLastName( fullName.getLastName() );

        return fullNameResponse;
    }
}
