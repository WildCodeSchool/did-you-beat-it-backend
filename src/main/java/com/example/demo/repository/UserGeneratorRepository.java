package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserGeneratorRepository implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if(this.userRepository.count() == 0) {

            List<User> users = new ArrayList<>();

            users.add(new User("Ergy", "ergy@wild.com", "fr0ntDev!","", "ergy", true));
            users.add(new User("Marwa", "marwa@wild.com", "Mt!dev46", "", "marwa", false));
            users.add(new User("Filip", "filip@wild.com", "7devFS!52", "", "filip", false));
            users.add(new User("Sid Ahmed", "sidahmed@wild.com", "5Sa!Api85", "", "sid-ahmed", false));
            users.add(new User("Clotilde", "clotilde@wild.com", "74!Bomg3K", "", "clotilde", false));

            this.userRepository.saveAll(users);
        }
    }
}
