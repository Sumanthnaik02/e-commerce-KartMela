package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.AuthService;
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
    private AuthService authService;

    /**
     *register a new user
     * @param user user details (email,username,password)
     * @return success or error message
     */
    @PostMapping ("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String result = authService.register(user); // make sure register
        if(result.contains("success")){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.badRequest().body(result);
        }
        /**
         *
         */
    }
}
