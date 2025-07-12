package com.silicon.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silicon.management.model.User;
import com.silicon.management.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class LoginController {

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User us)
	{
		User found = userRepo.findByUsernameAndPassword(us.getUsername(),us.getPassword());
		  if (found != null) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	}
	
}
