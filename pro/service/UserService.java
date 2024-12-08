package com.klu.pro.service;

import com.klu.pro.entity.User;
import com.klu.pro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Save user with hashed password
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Hash password
        return userRepository.save(user);
    }

    // Validate user by checking email and hashed password
    public User validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;  // Valid user
        }
        return null;  // Invalid user
    }
}
