package com.platform.logiciels.services;

import com.platform.logiciels.entities.Role;
import com.platform.logiciels.entities.User;

public interface UserService {
    void deleteAllusers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser (String username, String roleName);
}