package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {

    // load all per user
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
    List<Credential> findAllByUserId(Integer userid);

    // insert one
    @Insert("INSERT INTO CREDENTIALS (userid, url, username, skeleton, key, password) VALUES (#{userid}, #{url}, #{username}, #{skeleton}, #{key}, #{password})")
    Integer save(Credential credential);

    // load one for edit
    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    Credential findById(Integer credentialid);

    @Update("UPDATE CREDENTIALS SET url = #{credential.url}, username = #{credential.username}, password = #{credential.password} WHERE credentialid = #{credential.credentialid}")
    Integer update(Credential credential);

    // delete one
    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    void deleteById(Integer credentialid);
}
