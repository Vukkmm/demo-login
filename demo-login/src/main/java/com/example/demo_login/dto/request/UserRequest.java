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
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String province;
    private String district;
    private String ward;

}
