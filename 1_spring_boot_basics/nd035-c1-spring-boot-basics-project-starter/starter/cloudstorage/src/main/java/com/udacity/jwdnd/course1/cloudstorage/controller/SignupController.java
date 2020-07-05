package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.ui.Model;

@Controller()
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView() {
        return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        String signuperror = null;

        if (!userService.isUsernameAvailable(user.getUsername())) {
            signuperror = "The username already exists.";
        }

        if (signuperror == null) {
            int rowsAdded = userService.createUser(user);
            if (rowsAdded < 0) {
                signuperror = "There was an error signing you up. Please try again.";
            }
        }

        if (signuperror == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signuperror);
        }

        return "signup";
    }
}
