package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/file-upload")
public class FileController {

    private final FileService fileService;

    private final UserMapper userMapper;

    public FileController(FileService fileService, UserMapper userMapper) {
        this.fileService = fileService;
        this.userMapper = userMapper;
    }


    @PostMapping()
    public String upload(MultipartFile fileUpload, Model model, Authentication authentication) {
        System.out.println("first line");
        // NOTE: authentication will be null if we directly come to this page
        // TODO: guard this page from unauthorized access
        String username = authentication.getName();
        User user = userMapper.getUser(username);
        System.out.println(user.getUsername());

        // validate fileUpload request
        if(fileUpload.isEmpty()) {
            model.addAttribute("fileUploadEmpty", true);
            return "home";
        }

        //System.out.println(user.getUserId());
        fileService.upload(fileUpload, user.getUserId());
        List<File> fileList = fileService.getAllFilesByUserId(user.getUserId());
        for (File f: fileList) {
            System.out.println(f.getFileId() + " " + f.getUserId() + " " + f.getFilename());
        }
        model.addAttribute("fileUploadSuccess", true);
        model.addAttribute("files", fileService.getAllFilesByUserId(user.getUserId()));
        return "home";
    }

    /*
    public String upload(Authentication authentication) {
        String username = authentication.getName();
        System.out.println(username);
        return "signup";
    }*/
}
