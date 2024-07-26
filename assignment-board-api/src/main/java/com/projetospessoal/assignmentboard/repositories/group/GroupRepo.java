package com.projetospessoal.assignmentboard.repositories.group;

import com.projetospessoal.assignmentboard.entities.Group;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

public interface GroupRepo {
    Group create (String groupName) throws EtAuthException;
}
