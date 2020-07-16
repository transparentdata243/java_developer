package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @GetMapping("/home")
    public String homeView(Authentication authentication, Model model) {
        User savedUser = userService.getUser(authentication.getName());

        model.addAttribute("files", fileService.getAllFilesByUserId(savedUser.getUserid()));
        /*model.addAttribute("credentials", credentialService.getAllByUserid(savedUser.getUserid()));
        model.addAttribute("notes", notesService.getAllByUserid(savedUser.getUserid()));*/
        return "home";
    }
}
