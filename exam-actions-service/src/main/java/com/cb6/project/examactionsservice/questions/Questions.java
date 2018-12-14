package com.cb6.project.examactionsservice.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Questions {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer1")
	private String answerOne;
	
	@Column(name="answer2")
	private String answerTwo;
	
	@Column(name="answer3")
	private String answerThree;
	
	@Column(name="answer4")
	private String answerFour;
	
	@Column(name="trueanswer")
	private Integer trueanswer;
}
