package com.cb6.project.examactionsservice.exam;

import java.util.List;

import com.cb6.project.examactionsservice.questions.Questions;

public class ExamResults {
	
	private Integer userId;
	private List<Questions> list;
	
	public ExamResults() {}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Questions> getList() {
		return list;
	}

	public void setList(List<Questions> list) {
		this.list = list;
	}
	
	
}
