package com.example.demo_login.repository;

import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.AddressResponse;
import com.example.demo_login.entity.login.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    @Query("""
        SELECT new com.example.demo_login.dto.response.AddressResponse
        (r.id,r.province, r.district, r.ward)
        FROM Address r
        WHERE r.id=:id AND r.isDeleted= false
        """)
    AddressResponse detail(String id);
}
