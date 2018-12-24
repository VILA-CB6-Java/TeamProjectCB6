package com.cb6.project.adminannouncementsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cb6.project.adminannouncementsservice.AdminMessages;

public interface AdminMessagesRepository extends JpaRepository<AdminMessages, String> {
	
	List<AdminMessages> findAllByOrderByDtimeDesc();
	
}
