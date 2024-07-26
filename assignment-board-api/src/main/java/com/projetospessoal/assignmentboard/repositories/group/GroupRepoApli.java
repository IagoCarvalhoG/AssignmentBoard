package com.projetospessoal.assignmentboard.repositories.group;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.projetospessoal.assignmentboard.entities.Group;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

@Repository
public class GroupRepoApli implements GroupRepo {
    private static final String SQL_CREATE = "INSERT INTO DB_GROUP(group_id,GROUP_NAME)VALUES(NEXTVAL( 'db_group_seq' ),?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Group create(String groupName) throws EtAuthException {
        try{
             KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, groupName);
                return ps;
            }, keyHolder);
            Integer id = (Integer) keyHolder.getKeys().get("group_id");
            Group group = new Group(id, groupName);
            return group;
        }catch(Exception e){
            throw new EtAuthException("Dados invalidos");
        }
    }
    
}
