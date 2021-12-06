package com.example.repository;

import com.example.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
