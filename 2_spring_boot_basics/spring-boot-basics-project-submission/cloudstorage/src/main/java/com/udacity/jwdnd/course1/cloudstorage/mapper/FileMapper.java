package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {
// insert, select, delete, update
    @Insert("INSERT INTO FILES (userid, filename, filedata) VALUES (#{userid}, #{filename}, #{filedata})")
    Integer save(File file);

    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> findAllByUserId(Integer userId);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileid}")
    void deleteById( Integer fileId);

    @Select("SELECT * FROM FILES WHERE fileid = #{fileid}")
    File findById(Integer fileId);
}
