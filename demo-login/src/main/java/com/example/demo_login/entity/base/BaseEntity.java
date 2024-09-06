package com.example.demo_login.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.UUID;

@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    private String id;
    @CreatedBy
    private String createBy;
    @CreatedDate
    private Long createAt;

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
    /**
     * Ensures that the entity has a valid ID before persisting.
     * If the ID is null, generates a new UUID and assigns it to the ID field.
     */
    @PrePersist
    public void ensureId() {
        this.id = Objects.isNull(this.id) ? UUID.randomUUID().toString() : this.id;
    }
}