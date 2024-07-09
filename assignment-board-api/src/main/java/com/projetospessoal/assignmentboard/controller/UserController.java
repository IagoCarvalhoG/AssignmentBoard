package com.projetospessoal.assignmentboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap){

        String firstName = (String) userMap.get("first_name");
        String lastName = (String) userMap.get("last_name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("user_password");
        String username = (String) userMap.get("username");
        User user = userService.registerUser(firstName, lastName, email,username, password);
        Map<String,String> map = new HashMap<>();
        map.put("message", "registered succesfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
