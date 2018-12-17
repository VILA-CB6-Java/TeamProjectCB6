package com.cb6.project.authservice.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInDB, String>{
	
	List<UserInDB> findByUsername(String username);

}
