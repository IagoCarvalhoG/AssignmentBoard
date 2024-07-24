package com.projetospessoal.assignmentboard.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospessoal.assignmentboard.Constants;
import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String, Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("user_password");
        User user = userService.validateUser(email, password);
        return new ResponseEntity<>(generateJWTToken(user),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap){

        String firstName = (String) userMap.get("first_name");
        String lastName = (String) userMap.get("last_name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("user_password");
        String username = (String) userMap.get("username");
        User user = userService.registerUser(firstName, lastName, email,username, password);
        return new ResponseEntity<>(generateJWTToken(user),HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user){
        long currentTime = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
        .setIssuedAt(new Date(currentTime))
        .setExpiration(new Date(currentTime + Constants.TOKEN_VALIDITY))
        .claim("userId", user.getUserId())
        .claim("email", user.getEmail())
        .claim("firstName", user.getFirstName())
        .claim("lastName", user.getLastName())
        .claim("picture", user.getPicture())
        .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
