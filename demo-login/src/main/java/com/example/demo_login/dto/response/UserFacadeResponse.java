package com.example.demo_login.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFacadeResponse {
    private String id;
    private String email;
    private String phoneNumber;
    private String accountId;
    private String addressId;
    private String fullNameId;
    private AccountResponse accountResponse;
    private AddressResponse addressResponse;
    private FullNameResponse fullNameResponse;
}
