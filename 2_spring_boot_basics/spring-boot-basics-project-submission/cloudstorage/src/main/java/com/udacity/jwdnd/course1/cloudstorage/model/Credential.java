package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class Credential {
    private Integer credentialid;
    private String url;
    private String username;
    private String skeleton;
    private String key;
    private String password;
    private Integer userid;

    public Credential(Integer userid, String url, String username, String password) {
        this.userid = userid;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Credential(Integer credentialid, String url, String username, String password, Integer userid) {
        this.credentialid = credentialid;
        this.userid = userid;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Credential(Integer credentialid, String url, String username, String skeleton, String key, String password, Integer userid) {
        this.credentialid = credentialid;
        this.url = url;
        this.username = username;
        this.skeleton = skeleton;
        this.key = key;
        this.password = password;
        this.userid = userid;
    }
}
