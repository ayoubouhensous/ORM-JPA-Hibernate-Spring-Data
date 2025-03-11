package com.example.hospitals.repositories;

import com.example.hospitals.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String username);
}
