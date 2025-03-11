package com.example.hospitals.service;

import com.example.hospitals.entities.Role;
import com.example.hospitals.entities.User;
import com.example.hospitals.repositories.RoleRepository;
import com.example.hospitals.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private RoleRepository RoleRepository;
    @Override
    public User addUser(User user) {
        return UserRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return RoleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return UserRepository.findUserByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return RoleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(Role role, User user) {
            user.getRoles().add(role);
            role.getUsers().add(user);
            UserRepository.save(user);
            RoleRepository.save(role);

    }

    @Override
    public User authenticate(String username, String password) {
        User user = UserRepository.findUserByUserName(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
