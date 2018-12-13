package com.cb6.project.useractionsservice.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb6.project.useractionsservice.Message;
import com.cb6.project.useractionsservice.repo.UserRepository;

@RestController
public class UserResource {
	
	@Autowired
	private UserRepository service;
	
	//Retrieve all users,ordered by username ASC.
	@CrossOrigin
	@GetMapping("/users")
	public List<Users> retrieveAllUsers() {
		List<Users> list= new ArrayList<Users>();
		list= service.findAllByOrderByUsernameAsc();
	 return list;	 
	}
	
	//Delete a user by given username. If username doesn't exist throw exception.
	@CrossOrigin
	@PostMapping("/users/delete")
	public Message deleteAUser(@Valid @RequestBody Users user) {
		Users user1= service.findByUsername(user.getUsername());
		if (user1==null)
			throw new UserNotFoundException("User "+user.getUsername()+" not found.");
		service.delete(user1);
		return new Message("User "+user.getUsername()+" deleted successfully. ");
	}
	
	//Retrieve a user by username.
	@CrossOrigin
	@PostMapping("/users/retrieve")
	public Users retrieveAUser(@Valid @RequestBody Users user) {
		Users user1= service.findByUsername(user.getUsername());
		if (user1==null)
			throw new UserNotFoundException("User "+user.getUsername()+" not found.");
		service.delete(user1);
		return user1;
	}
}