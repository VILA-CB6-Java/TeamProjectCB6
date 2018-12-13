package com.cb6.project.userregisterservice.user;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb6.project.userregisterservice.Message;
import com.cb6.project.userregisterservice.repo.UserRepository;

@RestController
public class UserResource {
	
	@Autowired
	private UserRepository service;
	
	//POST /users
	//Get user back if success or "Error" if username or password wrong.
	@CrossOrigin
	@PostMapping("/users/register")
	public Message createUser(@Valid @RequestBody Users user) {
		if(service.findByUsername(user.getUsername())!=null)
			throw new UserAlreadyExistsException("Username already exists.");
		if(service.findByEmail(user.getEmail())!=null)
			throw new UserAlreadyExistsException("Email already in use.");
		service.save(user);
		return new Message("User "+user.getUsername()+" created successfully! ");
	}
}