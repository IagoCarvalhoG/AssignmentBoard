package com.projetospessoal.assignmentboard.repositories;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

public interface UserRepo {
    User create (String firstName, String lastName, String email, String username, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
