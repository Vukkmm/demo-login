package com.example.demo_login.repository;

import com.example.demo_login.dto.response.AccountInformationBasic;
import com.example.demo_login.entity.login.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Modifying
    @Transactional
    @Query("""
        UPDATE Account a SET
         a.username = :username, a.password = :password 
         WHERE a.id = :id
        """)
    void update(String  id, String username, String pass);

    @Query("""
        SELECT new com.example.demo_login.dto.response.AccountInformationBasic(u.id, a.username,a.password,a.role) from Account a
        join User u on a.id = u.accountId
        where u.id = :id
        """)
    AccountInformationBasic findByUserId(String  id);

    Account findAccountByUsername(String username);
}
