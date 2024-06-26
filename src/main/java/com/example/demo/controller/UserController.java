package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users", description = "Get all users")
    @GetMapping("")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @Operation(summary = "Get one user by id", description = "Get one user by id")
    @GetMapping("/{id}")
    public User getOneById(@PathVariable Long id) {
        return this.userService.getOneById(id);
    }


    @Operation(summary = "Create user", description = "Create user")
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return this.userService.createUser(user);
    }
}
