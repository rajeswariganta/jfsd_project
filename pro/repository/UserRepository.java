package com.klu.pro.repository;

import com.klu.pro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);  // Fetch user by email
}
