package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Operation(summary = "Get one user by slug", description = "Get one user by slug")
    @GetMapping("/{slug}")
    public User getOneBySlug(@PathVariable String slug) {
        return this.userService.getOneBySlug(slug);
    }

    @Operation(summary = "Create user", description = "Create user")
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @Operation(summary = "Update user", description = "Update user")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user, @RequestParam(defaultValue = "none") String picture) {
        switch(picture) {
            case "banner":
                return this.userService.updateBanner(id, user);
            
            case "profile": 
                return this.userService.updateProfilePicture(id, user);

            case "none":
                return this.userService.updateUser(id, user);

            default:
                return this.userService.updateUser(id, user);
        }
    }

    @Operation(summary = "Delete user", description = "Delete user")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }
}