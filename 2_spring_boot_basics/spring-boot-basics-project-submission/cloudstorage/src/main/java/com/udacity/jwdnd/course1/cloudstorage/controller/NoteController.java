package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class NoteController {

    private final NoteService noteService;

    private final UserMapper userMapper;

    public NoteController(NoteService noteService, UserMapper userMapper) {
        this.noteService = noteService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add-note")
    public String upload(Authentication authentication, Integer noteid, String notetitle, String notedescription, Model model) {
        // We check if the note exist, if it does, this is an update, otherwise add new note
        // NOTE: authentication will be null if we directly come to this page
        // TODO: guard this page from unauthorized access
        String username = authentication.getName();
        User user = userMapper.getUser(username);

        Note note = noteService.getById(noteid);
        if (note != null) {
            noteService.update(new Note(noteid, notetitle, notedescription, user.getUserid()));
        }
        noteService.upload(notetitle, notedescription, user.getUserid());
        List<Note> NoteList = noteService.getAllNotesByUserid(user.getUserid());
        for (Note f: NoteList) {
            System.out.println(f.getNoteid() + " " + f.getUserid() + " " + f.getNotetitle());
        }
        model.addAttribute("notes", noteService.getAllNotesByUserid(user.getUserid()));
        return "home";
    }

    @RequestMapping("/note-delete/{noteid}")
    public String delete(Authentication authentication, Model model, @PathVariable("noteid") Integer noteid) {
        noteService.delete(noteid);
        String username = authentication.getName();
        User user = userMapper.getUser(username);
        model.addAttribute("noteid", noteService.getAllNotesByUserid(user.getUserid()));
        return "home";
    }
}
