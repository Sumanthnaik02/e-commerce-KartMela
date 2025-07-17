package com.ecommerce.security;

import com.ecommerce.model.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    // secretKey used to sign and verify
    private static final String SECRET_KEY = "my_secret_key_for_kartemela";

    //expiration time in mili seconds-24hrs
    private static final long EXPIRATION_TIME = 24*60*60*1000;

    /**
     * generates jwt tokens using user info
     * @param user authenticated user
     * @return signed JWT token string
     */

    public static String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())   //set email as token subjects
                .claim("role",user.getRole()) //add user role in payload
                .setIssuedAt(new Date()) //current time
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME)) //set expiry
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY) //sign with secret key
                .compact(); //generate token
    }
    /**
     * validates tokens and return true if valid
     * @param token JWT to validate
     * @return true if token is valid
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)  //verify using the secret key
                    .parseClaimsJws(token);  //throws exception if invalid
            return true;
        }catch (JwtException | IllegalArgumentException e) {
            return false;  //invalid token
        }
    }

    /**
     * Extracts the email(subject) from the JWT token
     * @param token JWT token
     * @return email as string
     */
    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("role",String.class); //returns claims
    }
}
