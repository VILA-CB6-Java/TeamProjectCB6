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
@Table(name="messages")
public class AdminMessages {
	
	@Id
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String body;
	
	@Column(name="username")
	private String username;
	
	@Column
	private  String dtime;
	
	public AdminMessages() {
		
	}

	public AdminMessages(int id, String body, String username, String dtime) {
		super();
		this.id = id;
		this.body = body;
		this.username = username;
		this.dtime = dtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	
	

}
