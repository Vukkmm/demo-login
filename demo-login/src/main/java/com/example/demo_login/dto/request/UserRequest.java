package com.example.demo_login.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class UserRequest {
    private String accountNumber;
    private String email;
    private String phoneNumber;
    private String accountId;
    private String addressId;
    private String fullNameId;
}
