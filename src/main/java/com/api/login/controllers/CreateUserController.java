package com.api.login.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;
import com.api.login.services.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateUserController {
    @Autowired
    private UserRepositories repository;

    @Autowired
    private CreateUserService service;

    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password
        ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            service.save(name, email, password);
        }
}
