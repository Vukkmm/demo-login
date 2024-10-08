package com.example.demo_login.dto.response;

import com.example.demo_login.entity.login.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponse {
    private String id;
    private String username;
    private String password;
    private Set<String> roles;


}
