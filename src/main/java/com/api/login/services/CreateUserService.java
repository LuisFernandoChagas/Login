package com.api.login.services;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    private UserRepositories repository;

    public void save(String name, String email, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(repository.findByEmail(email) != null){
            throw new Error("Email already exists!");
        }

        if(name == null){
            throw new Error("Name not defined!");
        }

        if(password == null){
            throw new Error("Password not defined!");
        }

        MessageDigest passwordHash = MessageDigest.getInstance("MD5");
        byte messageDigest[] = passwordHash.digest(password.getBytes("UTF-8"));

        String finalPassword = new String(messageDigest, StandardCharsets.US_ASCII);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(finalPassword);

        repository.save(user);
    }
}
