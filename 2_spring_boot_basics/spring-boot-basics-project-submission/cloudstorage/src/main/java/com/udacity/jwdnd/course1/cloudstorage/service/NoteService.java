package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    public Note upload(String notetitle, String notedescription, Integer userid) {
        Note note = new Note(userid, notetitle, notedescription);
        noteMapper.save(note);
        return note;
    }

    public Integer update(Note note) {
        return noteMapper.update(note);
    }

    public List<Note> getAllNotesByUserid(int userid) {
        return noteMapper.findAllByUserId(userid);
    }

    public Note getById(Integer noteid) {
        return noteMapper.findById(noteid);
    }

    public void delete(Integer noteid) {
        noteMapper.deleteById(noteid);
    }
}
