package com.platform.logiciels.repos;

import com.platform.logiciels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}