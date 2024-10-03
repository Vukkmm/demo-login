package com.example.demo_login.entity.login;

import com.example.demo_login.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "accounts")
public class Account extends BaseEntityWithUpdater {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


    @ElementCollection
    @Column(name = "role")
    private Set<String> roles ;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "account_roles",
//            joinColumns = @JoinColumn(name = "account_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_name")
//    )
//    private Set<Role> roles;


    public Account(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
