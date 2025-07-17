package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    //password encoder using bcrypt for hashing passwords
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * registers new user in the system
     *
     * @param user the user object containing email,username,password
     * @return success or failure msg
     */

    public String register(User user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            return "Email already registered..!";
        }
        //encrypt user password
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        //set password
        user.setPassword(encodedPassword);

        //assign default role for new user
        user.setRole("USER");

        userRepo.save(user);
        return "User registered successfully..!";
    }

    /**
     * Logs in a user by verifying email and password
     *
     * @param email       user's email
     * @param rawPassword plain-text password from login-from
     * @return jwt token if login successful,null if failed
     */

    public String login(String email, String rawPassword) {

        //find user by email
        Optional<User> userOpt = userRepo.findByEmail(email);

        //check user exists
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            //match the input and db password
            boolean match = passwordEncoder.matches(rawPassword, user.getPassword());

            if (match) {
                return JwtUtil.generateToken(user); //returns a signed JWT string
            }
        }
        return "login failed";
    }

    /**
     * Fetch user details by email (useful for profile, validation, etc.)
     *
     * @param email user's email address
     * @return Optional<User> object (may be empty if not found)
     */
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);  // returns user if exists
    }
}
