package com.cb6.project.authservice.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserInDB {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column(name="last_name")
	private String lastName;

	
	@Column
	private String role;
	
	public UserInDB() {
		
	}
	
	
	public UserInDB(int id, String firstName, String lastName, String username, String email, String password,
			String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getRole() {
		return role;
	}

   public void setRole(String role) {
		this.role = role;
	}


	
	

}
