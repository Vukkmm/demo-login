package com.example.demo_login.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String email;
    String phoneNumber;
    @Size(min = 6, max = 50, message = "Username must be between 3 and 50 characters")
    String username;
    @Size(min = 8)
    String password;
    String province;
    String district;
    String ward;
    String firstName;
    String lastName;
    List<String> roles;

}
