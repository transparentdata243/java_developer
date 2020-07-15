package com.udacity.jwdnd.spring_security_basics.model;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messageText;
    // note that messageId also requires setter and getter
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
