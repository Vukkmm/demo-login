package com.example.demo_login.repository;

import com.example.demo_login.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
