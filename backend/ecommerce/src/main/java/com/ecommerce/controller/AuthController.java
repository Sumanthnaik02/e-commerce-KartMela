package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")  //All routes here will start with /api/auth
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     *user signup
     * POST /api/auth/signup
     * Body: { "name": "...","email":"..."password":"...","role":"user"}
     */
    @PostMapping ("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        // if user already exists
        if(UserRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        //hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
