package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
//import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/auth")  //All routes here will start with /api/auth
public class AuthController {

    @Autowired
    private AuthService authService;

    //     register a new user
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    //login a user
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        return authService.loginUser(email, password);
    }
}
