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

    public User getOneBySlug(String slug) {
        User user = this.userRepository.findBySlug(slug);
        return user;
    }

    public User createUser(User user) {
        user.setSlug(slugify.slugify(user.getUsername()));
        return this.userRepository.save(user);
    }

    public User findByemail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User user) {
        User retrievedUser = this.userRepository.findById(id).get();
        retrievedUser.setUsername(user.getUsername());
        retrievedUser.setSlug(slugify.slugify(user.getUsername()));
        retrievedUser.setEmail(user.getEmail());
        retrievedUser.setBiography(user.getBiography());
        if (user.getPassword() != null) {
            retrievedUser.setPassword(user.getPassword());
        }
        
        return this.userRepository.save(retrievedUser);
    }

    public User updateBanner(Long id, User user) {
        User retrievedUser = this.userRepository.findById(id).get();
        retrievedUser.setBannerPicture(user.getBannerPicture());
        return this.userRepository.save(retrievedUser);
    }

    public User updateProfilePicture(Long id, User user) {
        User retrievedUser = this.userRepository.findById(id).get();
        retrievedUser.setProfilePicture(user.getProfilePicture());
        return this.userRepository.save(retrievedUser);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}