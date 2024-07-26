package com.projetospessoal.assignmentboard.services.user;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

public interface UserService {
    
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String username, String password) throws EtAuthException;
}
