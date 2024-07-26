package com.projetospessoal.assignmentboard.entities;

public class Relational {
    private Integer userId;
    private Integer groupId;

    public Relational(Integer userId, Integer groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
