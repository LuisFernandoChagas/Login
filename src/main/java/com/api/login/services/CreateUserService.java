package com.api.login.services;

import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    private UserRepositories repository;

    public void save(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        repository.save(user);
    }
}
