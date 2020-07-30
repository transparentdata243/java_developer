package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    // load all per user
    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Note> findAllByUserId(Integer userid);

    // insert one
    @Insert("INSERT INTO NOTES (userid, notetitle, notedescription) VALUES (#{userid}, #{notetitle}, #{notedescription})")
    Integer save(Note note);

    // load one for edit
    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note findById(Integer noteid);

    @Update("UPDATE NOTES SET notetitle = #{note.notetitle}, notedescription = #{note.notedescription} WHERE noteid = #{note.noteid}")
    Integer update(Note note);

    // delete one
    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    void deleteById(Integer noteid);
}
