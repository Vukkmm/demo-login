package com.example.demo_login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String email;
    private String phoneNumber;
    private String accountId;
    private String addressId;
    private String fullNameId;

    public UserResponse(String accountId, String addressId, String fullNameId) {
        this.accountId = accountId;
        this.addressId = addressId;
        this.fullNameId = fullNameId;
    }
}
