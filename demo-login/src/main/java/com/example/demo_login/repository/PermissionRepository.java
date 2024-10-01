package com.example.demo_login.repository;

import com.example.demo_login.entity.login.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
