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

    public User updateUser(Long id, User user) {
        User retrievedUser = this.userRepository.findById(id).get();
        retrievedUser.setUsername(user.getUsername());
        retrievedUser.setSlug(slugify.slugify(user.getUsername()));
        retrievedUser.setEmail(user.getEmail());
        retrievedUser.setPassword(user.getPassword());
        retrievedUser.setBannerPicture(user.getBannerPicture());
        retrievedUser.setProfilePicture(user.getProfilePicture());
        retrievedUser.setBiography(user.getBiography());

        return this.userRepository.save(retrievedUser);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
