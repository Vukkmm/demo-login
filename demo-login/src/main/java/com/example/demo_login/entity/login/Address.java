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
@Table(name = "addresses")
public class Address extends BaseEntityWithUpdater {
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Address(String province, String district, String ward) {
        this.province = province;
        this.district = district;
        this.ward = ward;
    }
}
