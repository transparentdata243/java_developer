package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
    /*credentialid INT PRIMARY KEY auto_increment,
    url VARCHAR(100),
    username VARCHAR (30),
    key VARCHAR,
    password VARCHAR,
    userid INT,
    foreign key (userid) references USERS(userid)
     */
    private Integer credentialId;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userId;

    public String getUrl() {
        return url;
    }

    public void setUrl() {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey() {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = userId;
    }
}
