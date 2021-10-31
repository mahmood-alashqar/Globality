package com.example.globality.Infrastructure;

import com.example.globality.Domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    // queries
    Optional<Roles> findRoleByName(String name);
}
