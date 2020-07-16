package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public File upload(MultipartFile multipartFile, Integer userId) {
        File file = null;
        try {
            file = new File(userId, multipartFile.getOriginalFilename(), multipartFile.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
        fileMapper.save(file);
        return file;
    }

    public List<File> getAllFilesByUserId(int userId) {
        return fileMapper.findAllByUserId(userId);
    }

    public File getById(Integer fileId) {
        return fileMapper.findById(fileId);
    }

    public void delete(Integer fileId) {
        System.out.println("delete fileId = " + fileId);
        fileMapper.deleteById(fileId);
    }

    public MultipartFile download(Integer fileId) {
        return null;
    }
}
