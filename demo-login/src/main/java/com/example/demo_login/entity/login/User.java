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
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "fullname_id")
    private String fullNameId;
    @Column(name = "is_deleted")
    private boolean isDeleted;


    public User(String email, String phoneNumber, String accountId, String addressId, String fullNameId) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
        this.addressId = addressId;
        this.fullNameId = fullNameId;
    }
}
