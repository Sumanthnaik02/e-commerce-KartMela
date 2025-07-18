package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already registered!";
        }
        //Note in real app hash password before saving
        user.setRole("USER");
        userRepository.save(user);
        return "Registration successful!";
    }

    public String loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    if (user.getPassword().equals(password)) {
                        return "Login successful!";
                    } else {
                        return "Invalid password!";
                    }
                })
                .orElse("User not found!");
    }
}
