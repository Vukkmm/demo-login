package com.example.demo_login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameResponse {
    private String id;
    private String firstName;
    private String lastName;
}
