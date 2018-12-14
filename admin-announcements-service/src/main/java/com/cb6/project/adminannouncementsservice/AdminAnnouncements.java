package com.cb6.project.adminannouncementsservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="announcements")
public class AdminAnnouncements {
	
	@Id
	//@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="ann_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String body;
	
	@Column
	private  String dtime;
	
	public AdminAnnouncements() {
		
	}

	public AdminAnnouncements(int id, String title, String body, String dtime) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.dtime = dtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	
	

}
