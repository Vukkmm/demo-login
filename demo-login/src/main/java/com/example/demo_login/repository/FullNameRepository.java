package com.example.demo_login.repository;

import com.example.demo_login.entity.login.FullName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullNameRepository extends JpaRepository<FullName, String> {

}
