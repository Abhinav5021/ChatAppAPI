package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chatService {
	
	@Autowired
	chatRepository repo;
	
	 public User saveUser(User user) {
	        return repo.save(user);
	    }
}
