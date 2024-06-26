package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.github.slugify.Slugify;

@Service
public class UserService {

    private Slugify slugify = Slugify.builder().build();
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User getOneById(Long id) {
        User user = this.userRepository.findById(id).get();
        return user;
    }

    public User createUser(User user) {
        user.setSlug(slugify.slugify(user.getUsername()));
        return this.userRepository.save(user);
    }

}
