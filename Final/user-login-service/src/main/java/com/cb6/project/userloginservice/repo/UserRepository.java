package com.cb6.project.userloginservice.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cb6.project.userloginservice.user.Users;

public interface UserRepository extends JpaRepository<Users, String>{
	Users findByUsername(String username);
}
