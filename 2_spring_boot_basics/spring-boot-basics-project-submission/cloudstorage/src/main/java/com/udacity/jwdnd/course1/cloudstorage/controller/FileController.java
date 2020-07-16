package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class FileController {

    private final FileService fileService;

    private final UserMapper userMapper;

    public FileController(FileService fileService, UserMapper userMapper) {
        this.fileService = fileService;
        this.userMapper = userMapper;
    }

    @PostMapping("/file-upload")
    public String upload(Authentication authentication, MultipartFile fileUpload, Model model) {
        // NOTE: authentication will be null if we directly come to this page
        // TODO: guard this page from unauthorized access
        String username = authentication.getName();
        User user = userMapper.getUser(username);

        // validate fileUpload request
        if(fileUpload.isEmpty()) {
            model.addAttribute("fileUploadEmpty", true);
            return "home";
        }

        fileService.upload(fileUpload, user.getUserid());
        List<File> fileList = fileService.getAllFilesByUserId(user.getUserid());
        for (File f: fileList) {
            System.out.println(f.getFileid() + " " + f.getUserid() + " " + f.getFilename());
        }
        model.addAttribute("fileUploadSuccess", true);
        model.addAttribute("files", fileService.getAllFilesByUserId(user.getUserid()));
        return "home";
    }

    @RequestMapping("/file/view/{fileid}")
    public void view(HttpServletResponse response, @PathVariable("fileid") Integer fileid) throws IOException {
        File file = fileService.getById(fileid);
        IOUtils.copy(new ByteArrayInputStream(file.getFiledata()), response.getOutputStream());
    }

    @RequestMapping("/file-delete/{fileid}")
    public String delete(Authentication authentication, Model model, @PathVariable("fileid") Integer fileid) {
        fileService.delete(fileid);
        String username = authentication.getName();
        User user = userMapper.getUser(username);
        model.addAttribute("files", fileService.getAllFilesByUserId(user.getUserid()));
        return "home";
    }

    @RequestMapping("/file/download/{fileid}")
    public ResponseEntity<Resource> download(@PathVariable("fileid") Integer fileid) {
        File file = fileService.getById(fileid);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = " + file.getFilename());
        header.add("Cache-control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        ByteArrayResource resource = new ByteArrayResource((file.getFiledata()));
        // TODO: add size and content type for property http response
        return ResponseEntity.ok()
                .headers(header)
                .body(resource);
    }
}
