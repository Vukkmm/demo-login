package com.example.demo_login.repository;

import com.example.demo_login.dto.response.UserResponse;
import com.example.demo_login.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("""
        SELECT new com.example.demo_login.dto.response.UserResponse
        (r.id, r.email, r.phoneNumber, r.accountId, r.addressId, r.fullNameId)
        from User r
        WHERE r.id=:id AND r.isDeleted = false 
    """)
    UserResponse detail(String id);

}
