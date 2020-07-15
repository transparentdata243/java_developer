package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/", "/login"})
public class LoginController {

    @GetMapping()
    public String loginView() {
        return "login";
    }

}

