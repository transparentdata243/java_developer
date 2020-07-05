package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CredentialMapper {

    @Select("select * from credentials where credentials.credentialId = #{id}")
    Credential findById(@Param("id") Integer Id);

    @Select("select * from credentials(usl, username, password, userid VALUES (#{credential.url}, #{credential.username}, #{credential.password}, #{userid})")
    List<Credential> findAllByUserId(@Param("userId") Integer userid);

    //@Insert("insert into credentials(url, username, password, userid) VALUES (#{credential.username})")
}
