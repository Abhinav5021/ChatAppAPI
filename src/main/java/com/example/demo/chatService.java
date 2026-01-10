package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chatService {
	
	@Autowired
	chatRepository repo;
	
	 public User saveUser(User user) {
	        return repo.save(user);
	    }
	 public String generateOtp() {
	        return String.valueOf((int)(Math.random() * 900000) + 100000);
	    }
	 public LocalDateTime expiryTime() {
	        return LocalDateTime.now().plusMinutes(5);
	    }
	

}
