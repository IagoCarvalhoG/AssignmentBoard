package com.projetospessoal.assignmentboard.resources;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResources {
    
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, Object> userMap){

        String firstName = (String) userMap.get("first_name");
        String lastName = (String) userMap.get("last_name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        String username = (String) userMap.get("username");
        return firstName + ", " + lastName + ", " + email + ", " + username + ", " + password;
    }
}
