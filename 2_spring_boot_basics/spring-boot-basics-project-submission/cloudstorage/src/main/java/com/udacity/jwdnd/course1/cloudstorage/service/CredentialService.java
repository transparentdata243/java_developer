package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    @Autowired
    private CredentialMapper credentialMapper;

    @Autowired
    private EncryptionService encryptionService;

    public Credential upload(String url, String username, String password, Integer userid) {
        // hash password
        Credential credential = new Credential(userid, url, username, password);
        String skeleton = RandomStringUtils.random(16, true, true);
        credential.setSkeleton(skeleton);
        String encryptPW = encryptionService.encryptValue(credential.getPassword(), skeleton);
        credential.setPassword(encryptPW);
        credentialMapper.save(credential);
        return credential;
    }

    public Integer update(Credential credential) {
        return credentialMapper.update(credential);
    }

    public List<Credential> getAllCredentialsByUserid(int userid) {
        return credentialMapper.findAllByUserId(userid);
    }

    public Credential getById(Integer credentialid) {
        return credentialMapper.findById(credentialid);
    }

    public void delete(Integer credentialid) {
        credentialMapper.deleteById(credentialid);
    }
}
