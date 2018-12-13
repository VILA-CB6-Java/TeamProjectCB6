package com.cb6.project.useractionsservice.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb6.project.useractionsservice.user.Users;

public interface UserRepository extends JpaRepository<Users, String>{
	Users findByUsername(String username);
	List<Users> findAllByOrderByUsernameAsc();
}
