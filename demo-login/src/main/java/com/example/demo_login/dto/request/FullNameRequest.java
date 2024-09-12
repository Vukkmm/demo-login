package com.example.demo_login.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class FullNameRequest {
    private String firstName;
    private String lastName;


}
