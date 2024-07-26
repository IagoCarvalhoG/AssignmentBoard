package com.projetospessoal.assignmentboard.services.group;

import com.projetospessoal.assignmentboard.entities.Group;
import com.projetospessoal.assignmentboard.exceptions.EtAuthException;

public interface GroupService {
    Group createGroup(String groupName) throws EtAuthException;
}
