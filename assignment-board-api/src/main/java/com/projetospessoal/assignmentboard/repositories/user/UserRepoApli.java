package com.projetospessoal.assignmentboard.repositories.user;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.stereotype.Repository;

import com.projetospessoal.assignmentboard.entities.User;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

@Repository
public class UserRepoApli implements UserRepo {

    private static final String SQL_CREATE = "INSERT INTO DB_USER(user_id,FIRST_NAME, LAST_NAME, USERNAME, EMAIL, user_PASSWORD)VALUES(NEXTVAL( 'db_user_seq' ),?, ?, ?, ?, ?)";

    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) AS count FROM DB_USER WHERE EMAIL = ?";

    private static final String SQL_FIND_BY_ID = "SELECT user_id, FIRST_NAME, LAST_NAME, USERNAME, EMAIL, user_PASSWORD " +
    "FROM DB_USER WHERE USER_ID = ?";

    private static final String SQL_FIND_BY_EMAIL = "SELECT user_id, FIRST_NAME, LAST_NAME, USERNAME, EMAIL, user_PASSWORD, PICTURE " +
    "FROM DB_USER WHERE EMAIL = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User create(String firstName, String lastName, String email, String username, String password)
            throws EtAuthException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, username);
                ps.setString(4, email);
                ps.setString(5, hashedPassword);

                return ps;
            }, keyHolder);
            Integer id = (Integer) keyHolder.getKeys().get("user_id");
            User user = new User(id, firstName, lastName, username, email, password, null);
            return user;
        } catch(Exception e){
            // throw new EtAuthException();
            throw new EtAuthException("Dados invalidos");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        try{
            Object[] args={email};
            int[] argTypes = {JDBCType.VARCHAR.getVendorTypeNumber()};
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, args,argTypes , userRowMapper);
            if(!BCrypt.checkpw(password, user.getPassword())){
                throw new EtAuthException("email or password does not exist");
            }
            return user;
        }catch(EmptyResultDataAccessException e){
            throw new EtAuthException("email or password does not exist");
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        
        Object[] args={email};
        int[] argTypes = {JDBCType.VARCHAR.getVendorTypeNumber()};
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, args, argTypes,Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        Object[] args = {userId};
        int[] argTypes = {JDBCType.INTEGER.getVendorTypeNumber()};
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,args, argTypes, userRowMapper);
        
    }

    private RowMapper<User> userRowMapper = ((rs,rowNum)->{
        return new User(rs.getInt("user_id"),
        rs.getString("first_name"),
        rs.getString("last_name"),
        rs.getString("username"), 
        rs.getString("email"),
        rs.getString("user_password"),
        rs.getString("picture"));
    });
    
}
