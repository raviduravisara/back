package com.SalonManagement.service;

import com.SalonManagement.model.User;
import com.SalonManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    // Add this method to save a user and return the saved entity
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
