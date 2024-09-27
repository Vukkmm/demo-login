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
    private String username;
    private AccountResponse accountResponse;
    private AddressResponse addressResponse;
    private FullNameResponse fullNameResponse;

    public UserFacadeResponse(String id,
                              String email,
                              String phoneNumber,
                              String accountId,
                              String addressId,
                              String fullNameId,
                              AccountResponse accountResponse,
                              AddressResponse addressResponse,
                              FullNameResponse fullNameResponse) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
        this.addressId = addressId;
        this.fullNameId = fullNameId;
        this.accountResponse = accountResponse;
        this.addressResponse = addressResponse;
        this.fullNameResponse = fullNameResponse;
    }
}
