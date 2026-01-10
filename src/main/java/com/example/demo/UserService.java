package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private chatRepository repo;

    @Transactional
    public User updateUser(User updatedUser) {
        // Step 1: Fetch existing user by username
        User existingUser = repo.findByUserName(updatedUser.getUserName());
        if (existingUser == null) {
            return null; // Let controller handle 404
        }

        // Step 2: Copy only non-null fields
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        }
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(updatedUser.getPassword());
        }

        // Step 3: Save the existing user with original ID
        return repo.save(existingUser);
    }
}