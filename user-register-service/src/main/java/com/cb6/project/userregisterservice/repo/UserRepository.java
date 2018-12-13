package com.cb6.project.userregisterservice.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cb6.project.userregisterservice.user.Users;

public interface UserRepository extends JpaRepository<Users, String>{
	Users findByUsername(String username);
	Users findByEmail(String email);
}
