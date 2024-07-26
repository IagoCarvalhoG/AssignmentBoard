package com.projetospessoal.assignmentboard.entities;

import java.sql.Date;

public class Assignments {
    private Integer assignmentId;
    private Integer groupId;
    private String assignmentName;
    private String assignmentDesc;
    private String userAssigned;
    private Boolean isFinished;
    private Date deadline;
    private Date timeFinished;

    public Assignments(Integer assignmentId, Integer groupId, String assignmentName, String assignmentDesc,
            String userAssigned, Boolean isFinished, Date deadline, Date timeFinished) {
        this.assignmentId = assignmentId;
        this.groupId = groupId;
        this.assignmentName = assignmentName;
        this.assignmentDesc = assignmentDesc;
        this.userAssigned = userAssigned;
        this.isFinished = isFinished;
        this.deadline = deadline;
        this.timeFinished = timeFinished;
    }
    
    public Integer getAssignmentId() {
        return assignmentId;
    }
    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public String getAssignmentName() {
        return assignmentName;
    }
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
    public String getAssignmentDesc() {
        return assignmentDesc;
    }
    public void setAssignmentDesc(String assignmentDesc) {
        this.assignmentDesc = assignmentDesc;
    }
    public String getUserAssigned() {
        return userAssigned;
    }
    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }
    public Boolean getIsFinished() {
        return isFinished;
    }
    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public Date getTimeFinished() {
        return timeFinished;
    }
    public void setTimeFinished(Date timeFinished) {
        this.timeFinished = timeFinished;
    }

}
