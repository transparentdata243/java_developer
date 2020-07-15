package com.udacity.jwdnd.spring_security_basics.mapper;

import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    // the (username, messagetext) are from the data model in schema.sql
    // #{username}, #{messageText} are from template chat.html
    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int addMessage(ChatMessage chatMessage);
}