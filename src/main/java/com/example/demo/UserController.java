package com.example.demo;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
@CrossOrigin("*") // Allow frontend access
public class UserController {

    @Autowired
    private UserService userService; // Rely on service, not repo directly

    @Autowired
    private UserRepository repo;

    // Unified Register/Add Endpoint
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // You might want to check if username exists first!
        return repo.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
        User user = repo.findByUserNameAndPassword(data.get("userName"), data.get("password"));
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/find")
    public ResponseEntity<User> findByUsername(@RequestParam String username) {
        return ResponseEntity.of(repo.findByUserName(username));
    }
    
    @GetMapping("/details")
    public User getUserDetails(@RequestParam String username) {
        return repo.findByUserName(username).orElse(null);
    }

    // Use the Service logic you wrote earlier
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
        User user = userService.updateUser(updatedUser);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok(user);
    }
}