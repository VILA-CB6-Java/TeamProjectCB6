package com.cb6.project.examactionsservice.questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="trueanswer")
	private Integer trueanswer;
	
	public Questions() {}
	
	public Questions(Questions q) {
		this.id=q.getId();
		this.question=q.getQuestion();
		this.answerOne=q.getAnswerOne();
		this.answerTwo=q.getAnswerTwo();
		this.answerThree=q.getAnswerThree();
		this.answerFour=q.getAnswerFour();
		this.trueanswer=q.getTrueanswer();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerOne() {
		return answerOne;
	}

	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	public String getAnswerTwo() {
		return answerTwo;
	}

	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	public String getAnswerThree() {
		return answerThree;
	}

	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}

	public String getAnswerFour() {
		return answerFour;
	}

	public void setAnswerFour(String answerFour) {
		this.answerFour = answerFour;
	}

	public Integer getTrueanswer() {
		return trueanswer;
	}

	public void setTrueanswer(Integer trueanswer) {
		this.trueanswer = trueanswer;
	}
	
	
}
