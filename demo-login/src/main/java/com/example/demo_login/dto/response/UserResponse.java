package com.example.demo_login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String accountNumber;
    private String email;
    private String phoneNumber;
    private String accountId;
    private String addressId;
    private String fullNameId;
    private AccountResponse accountResponse;
    private AddressResponse addressResponse;
    private FullNameResponse fullNameResponse;

    public UserResponse(String id, String accountNumber, String email, String phoneNumber, AccountResponse accountResponse, AddressResponse addressResponse, FullNameResponse fullNameResponse) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountResponse = accountResponse;
        this.addressResponse = addressResponse;
        this.fullNameResponse = fullNameResponse;
    }


    public UserResponse(String id,
                        String accountNumber,
                        String email,
                        String phoneNumber,
                        String accountId,
                        String addressId,
                        String fullNameId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
        this.addressId = addressId;
        this.fullNameId = fullNameId;
    }

}
