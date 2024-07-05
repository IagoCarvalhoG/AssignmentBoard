package com.projetospessoal.assignmentboard.services;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

public interface UserService {
    
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String username, String password, String email) throws EtAuthException;
}
