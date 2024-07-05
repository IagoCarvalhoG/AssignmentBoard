package com.projetospessoal.assignmentboard.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

@Repository
public class UserRepoApli implements UserRepo {

    private static final String SQL_CREATE = "INSERT INTO DB_USERS(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD,EMAIL)VALUES(NEXTVAL(?, ?, ?, ?, ?))";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User create(String firstName, String lastName, String email, String username, String password)
            throws EtAuthException {
        try{
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(0, firstName);
                ps.setString(1, lastName);
                ps.setString(2, email);
                ps.setString(3, username);
                ps.setString(4, password);
            }, keyHolder);
        } catch(Exception e){
            throw new EtAuthException("Invalid details. Account not created");
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crate'");
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmailAndPassword'");
    }

    @Override
    public Integer getCountByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountByEmail'");
    }

    @Override
    public User findById(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
