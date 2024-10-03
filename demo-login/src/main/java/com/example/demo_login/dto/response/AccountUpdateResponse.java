package com.example.demo_login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountUpdateResponse {
    private String id;
    private String username;
    private String password;
    private String role;
    private Set<RoleResponse> roles;
}
