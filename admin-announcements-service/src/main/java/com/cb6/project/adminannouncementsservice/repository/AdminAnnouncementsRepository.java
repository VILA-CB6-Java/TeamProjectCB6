package com.cb6.project.adminannouncementsservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cb6.project.adminannouncementsservice.AdminAnnouncements;


public interface AdminAnnouncementsRepository extends JpaRepository<AdminAnnouncements, String> {

	List<AdminAnnouncements> findTop10ByOrderByDtimeDesc();
	
	@Query("SELECT u FROM AdminAnnouncements u order by function('RAND')")
	Page<AdminAnnouncements> findRandom(Pageable pageable);
	
	
}
