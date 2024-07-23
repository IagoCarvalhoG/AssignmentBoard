package com.projetospessoal.assignmentboard.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;
import com.projetospessoal.assignmentboard.repositories.UserRepo;

@Service
@Transactional
public class UserServiceApli implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null){
            email = email.toLowerCase();
        }
        User user = userRepo.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String username, String password )
            throws EtAuthException {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        if(email!= null){
            email = email.toLowerCase();
        }
        if(!pattern.matcher(email).matches()){
            throw new EtAuthException("Invalid email Format");
        }
        Integer count = userRepo.getCountByEmail(email);
        if(count > 0) {
            throw new EtAuthException("Email already in use");
        }
        User user = userRepo.create(firstName, lastName, email, username, password);
        return user;
    }  
    
}
