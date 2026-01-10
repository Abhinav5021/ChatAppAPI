package com.example.demo;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private chatService service;

    @Autowired
    private chatRepository repo;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }
    
    @PostMapping("/login")
    public User login(@RequestBody Map<String,String> data) {
        return repo.findByUserNameAndPassword(data.get("userName"), data.get("password"));
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }





}
