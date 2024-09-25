package com.example.demo_login.entity.login;

import com.example.demo_login.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account extends BaseEntityWithUpdater {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


//    @ElementCollection
    @Column(name = "role")
    private String roles ;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
