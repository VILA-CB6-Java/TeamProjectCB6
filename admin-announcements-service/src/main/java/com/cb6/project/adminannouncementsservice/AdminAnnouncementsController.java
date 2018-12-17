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
import com.cb6.project.adminannouncementsservice.repository.AdminMessagesRepository;

@RestController
@CrossOrigin
public class AdminAnnouncementsController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AdminAnnouncementsRepository repository;
	
	@Autowired
	AdminMessagesRepository repository2;
	
	class Message {
		String body;
		
		public Message(String body) {
			this.body=body;
		}
		}
	
	
	@GetMapping("/announcements")
	public List<AdminAnnouncements> retrieveAnnouncement() {
		
		
		List<AdminAnnouncements> list = repository.findTop10ByOrderByDtimeDesc();
		
		
			
		
		return list;
	}
	
	@GetMapping("/announcements/random")
	public List<AdminAnnouncements> findRandomAnnouncements() {
		
		Page<AdminAnnouncements> page = repository.findRandom(PageRequest.of(0, 5));
        List<AdminAnnouncements> list = page.getContent();
        logger.info("{}", list);
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
	
	@GetMapping("/messages")
	public List<AdminMessages> retrieveMessages() {
		List<AdminMessages> list = repository2.findAll();
		return list;
		
	}
	
	@PostMapping("/messages/post")
	public AdminMessages postMessage(@RequestBody AdminMessages adminMessage) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adminMessage.setDtime(sdf.format(dt));
		
		AdminMessages newMessage = repository2.save(adminMessage);
		return newMessage;
	}
	
	@PostMapping("/messages/delete")
	public Message deleteMessage(@RequestBody AdminMessages adminMessage) {
		repository2.delete(adminMessage);
	return new Message("Message deleted!");
		
	}
	
	

}
