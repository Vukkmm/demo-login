package com.example.demo_login.repository;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.entity.login.FullName;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FullNameRepository extends JpaRepository<FullName, String> {
    @Modifying
    @Transactional
    @Query("""
        UPDATE FullName a SET
         a.firstName = :firstName, a.lastName = :lastName
         WHERE a.id = :id
        """)
    void updateFullNameByUserId(FullNameRequest fullNameRequest);

}
