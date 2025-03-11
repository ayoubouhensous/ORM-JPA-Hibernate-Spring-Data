package com.example.hospitals.service;

import com.example.hospitals.entities.Role;
import com.example.hospitals.entities.User;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(Role role, User user);
    User authenticate(String username, String password);
}
