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

    public Integer getFileId() {
        return fileid;
    }

    public void setFileId(int fileid) {
        this.fileid = fileid;
    }

    public Integer getUserId() {
        return userid;
    }

    public void setUserId(Integer userid) {
        this.userid = userid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }
}
