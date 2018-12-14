package com.cb6.project.adminannouncementsservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb6.project.adminannouncementsservice.repository.AdminAnnouncementsRepository;

@RestController
@CrossOrigin
public class AdminAnnouncementsController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AdminAnnouncementsRepository repository;
	
	
	@GetMapping("/announcements")
	public List<AdminAnnouncements> retrieveAnnouncement() {
		
		
		List<AdminAnnouncements> list = repository.findTop10ByOrderByDtimeDesc();
		
		
			
		
		return list;
	}
	
	@GetMapping("/announcements/random")
	public List<AdminAnnouncements> findRandomAnnouncements() {
		
		Page<AdminAnnouncements> page = repository.findRandom(PageRequest.of(0, 5));
        List<AdminAnnouncements> list = page.getContent();
		return list;
		
	}
	
	@PostMapping("/announcements/post")
	public AdminAnnouncements postAnnouncement(@RequestBody AdminAnnouncements adminAnnouncement) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adminAnnouncement.setDtime(sdf.format(dt));
		AdminAnnouncements newPost = repository.save(adminAnnouncement);
		return newPost;
		
	}
	
	

}
