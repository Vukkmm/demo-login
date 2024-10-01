package com.example.demo_login.repository;

import com.example.demo_login.entity.login.Permission;
import com.example.demo_login.entity.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
