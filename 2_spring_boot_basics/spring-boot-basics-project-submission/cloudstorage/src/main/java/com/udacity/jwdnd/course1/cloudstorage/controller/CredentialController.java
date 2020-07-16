package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CredentialController {
    private final CredentialService credentialService;

    private final UserMapper userMapper;

    public CredentialController(CredentialService credentialService, UserMapper userMapper) {
        this.credentialService = credentialService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add-credential")
    public String upload(Authentication authentication, Integer credentialid, String url, String username, String password, Model model) {
        // We check if the note exist, if it does, this is an update, otherwise add new note
        // NOTE: authentication will be null if we directly come to this page
        // TODO: guard this page from unauthorized access
        String loginUsername = authentication.getName();
        User user = userMapper.getUser(loginUsername);

        Credential credential = credentialService.getById(credentialid);
        System.out.println(credential + " " + credentialid + " " + url + " " + username + " " + password + " " + user.getUserid());
        if (credential != null) {
            //credentialService.update(new Credential(credentialid, url, username, password, user.getUserid()));
            credential.setUrl(url);
            credential.setUsername(username);
            credential.setPassword(password);
            credentialService.update(credential);
        }
        credentialService.upload(url, username, password, user.getUserid());
        List<Credential> credentialList = credentialService.getAllCredentialsByUserid(user.getUserid());
        for (Credential c: credentialList) {
            System.out.println(c.getCredentialid() + " " + c.getUrl() + " " + c.getUsername() + " " + c.getPassword() + " " + c.getUserid() );
        }
        model.addAttribute("credentials", credentialService.getAllCredentialsByUserid(user.getUserid()));
        return "home";
    }

    @RequestMapping("/credential-delete/{credentialid}")
    public String delete(Authentication authentication, Model model, @PathVariable("credentialid") Integer credentialid) {
        credentialService.delete(credentialid);
        String username = authentication.getName();
        User user = userMapper.getUser(username);
        model.addAttribute("credentialid", credentialService.getAllCredentialsByUserid(user.getUserid()));
        return "home";
    }
}
