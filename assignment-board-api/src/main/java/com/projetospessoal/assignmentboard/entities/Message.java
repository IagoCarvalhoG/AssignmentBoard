package com.projetospessoal.assignmentboard.entities;

import java.sql.Date;

public class Message {
    private String messageId;
    private Integer userId;
    private Integer groupId;
    private Date dateSent;
    private String messageText;

    public Message(String messageId, Integer userId, Integer groupId, Date dateSent, String messageText) {
        this.messageId = messageId;
        this.userId = userId;
        this.groupId = groupId;
        this.dateSent = dateSent;
        this.messageText = messageText;
    }
    
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
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
    public Date getDateSent() {
        return dateSent;
    }
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
