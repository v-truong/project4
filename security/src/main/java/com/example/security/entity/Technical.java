package com.example.security.entity;

import com.example.common.entity.BaseStoreEntity;
import com.example.common.entity.EntityBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Technical extends BaseStoreEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "unit", nullable = false)
    private String unit;
    private String categoryId;
}
