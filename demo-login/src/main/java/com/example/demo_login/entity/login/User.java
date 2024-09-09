package com.example.demo_login.entity.login;

import com.example.demo_login.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntityWithUpdater {
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "fullname_id")
    private String fullNameId;
}
