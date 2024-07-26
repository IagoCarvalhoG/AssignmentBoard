package com.projetospessoal.assignmentboard.services.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetospessoal.assignmentboard.entities.Group;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;
import com.projetospessoal.assignmentboard.repositories.group.GroupRepo;

@Service
@Transactional
public class GroupServiceApli implements GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Override
    public Group createGroup(String groupName) throws EtAuthException {
        Group group = groupRepo.create(groupName);
        return group;
    }
    
}
