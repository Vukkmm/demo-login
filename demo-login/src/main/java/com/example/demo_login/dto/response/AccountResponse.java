package com.example.demo_login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponse {
    private String id;
    private String username;
    private String password;
}
