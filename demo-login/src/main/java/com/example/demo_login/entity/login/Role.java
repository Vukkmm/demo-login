package com.example.demo_login.entity.login;

import com.example.demo_login.entity.base.BaseEntityWithUpdater;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
    @NoArgsConstructor
@Entity
@Table(name = "roles")
@Builder
public class Role {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_name"),
            inverseJoinColumns = @JoinColumn(name = "permission_name")
    )
    private Set<Permission> permissions;

    public Role(String name) {
        this.name = name;
    }
}
