package com.platform.logiciels.repos;

import com.platform.logiciels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}