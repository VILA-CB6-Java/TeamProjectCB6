package com.cb6.project.userloginservice.user;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cb6.project.userloginservice.repo.UserRepository;

@RestController
public class UserResource {
	
	@Autowired
	private UserRepository service;
	
	//POST /users
	//Get user back if success or "Error" if username or password wrong.
	@PostMapping("/users")
	public Users retrieveUser(@Valid @RequestBody Users user) {
		Users user1 = service.findByUsername(user.getUsername());
		if(user1==null) {
			throw new UserNotFoundException("Error");
			}
		if (!user.getPassword().equals(user1.getPassword())) 
			throw new UserWrongPasswordException("Error");
	 return user1;	 
	}
}