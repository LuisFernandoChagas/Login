package com.api.login.controllers;

import java.util.List;

import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;
import com.api.login.services.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
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
    public ResponseEntity<User> save(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password
    ){
        return new ResponseEntity<User>(service.save(name, email, password), HttpStatus.OK);
    }
}
