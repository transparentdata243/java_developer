package com.udacity.jwdnd.course1.cloudstorage.model;

import java.io.InputStream;

public class File {
    /*CREATE TABLE IF NOT EXISTS FILES (
            fileId INT PRIMARY KEY auto_increment,
            filename VARCHAR,
            contenttype VARCHAR,
            filesize VARCHAR,
            userid INT,
            filedata BLOB,
            foreign key (userid) references USERS(userid)
            );
     */
    private Integer fileId;
    private String fileName;
    private String fileSize;
    private Integer userId;
    private byte[] fileData;
}
