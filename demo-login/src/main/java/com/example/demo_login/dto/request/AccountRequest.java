package com.example.demo_login.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class AccountRequest {
    private String username;
    private String password;
}
