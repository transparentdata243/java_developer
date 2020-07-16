package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class File {
    private int fileid;
    private Integer userid;
    private String filename;
    private byte[] filedata;

    public File(Integer userid, String filename, byte[] filedata) {
        this.userid = userid;
        this.filename = filename;
        this.filedata = filedata;
    }
}
