package com.api.login.services;

import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    private UserRepositories repository;

    @Autowired
    private PasswordEncoder encoder;

    public User save(String name, String email, String password){
        if(repository.findByEmail(email) != null){
            throw new Error("Email already exists!");
        }

        if(email == null){
            throw new Error("Name and/or password not defined!");
        }

        if(password == null){
            throw new Error("Name and/or password not defined!");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        repository.save(user);

        return user;
    }
}
