 package com.cb6.project.examactionsservice.exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb6.project.examactionsservice.Grade;
import com.cb6.project.examactionsservice.Message;
import com.cb6.project.examactionsservice.questions.Questions;
import com.cb6.project.examactionsservice.repo.ExamsRepository;
import com.cb6.project.examactionsservice.repo.QuestionsRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;



@RestController
public class ExamsController {
	
	@Autowired
	private ExamsRepository service1;
	
	@Autowired
	private QuestionsRepository service2;
	
	
	//Retrieve 20 random questions.
	@CrossOrigin
	@GetMapping("/exam")
	public MappingJacksonValue retrieveQuestions() {
		List<Questions> list= new ArrayList<Questions>();
		Page<Questions> page = service2.findRandom(PageRequest.of(0, 20));
        list = page.getContent();
        String[] ignorableFieldNames = { "trueanswer"}; 
        MappingJacksonValue wrapper = new MappingJacksonValue(list);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("true answer filter", 
                SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
        wrapper.setFilters(filterProvider);
		return wrapper;	 
	}
	
	//exam submit -> returns grade %, insert to Exams table the record.
	@CrossOrigin
	@PostMapping("/exam/submit")
	public Grade calculateResult (@Valid @RequestBody ExamResults exam ) {
		Integer grade=0;
		int k=0;
		String dtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Integer userId=exam.getUserId();
		List<Questions> list1=exam.getList();
		List<Questions> list2=service2.findAll();
		for (Questions q1: list1) {
			for (Questions q2: list2) {
				if (q1.getId()==q2.getId()) {
					if(q1.getTrueanswer()==q2.getTrueanswer())
						grade++;
				}
			}
		}
		grade= grade*5;		
		service1.save(new Exams(dtime,grade,userId));
		return new Grade(grade);
	}
	
	//retrieve all exams of a user.
	@CrossOrigin
	@PostMapping("/exam/retrieve")
	public List<Exams> retrieveExam (@Valid @RequestBody Exams exam){
		List<Exams> list= new ArrayList<>();
		list= service1.findAllByUserId(exam.getUserId());
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/questions")
	public List<Questions> retrieveAllQuestions() {
		List<Questions> list= new ArrayList<>();
		list= service2.findAll();
		return list;
	}
	
	//update or add a question.
	@CrossOrigin
	@PostMapping("/questions/update")
	public Message updateQuestion (@Valid @RequestBody Questions question) {
		Message m;
		if (question.getId()!=null) { 
			m=new Message("Question updated successfully! ");
			}else {
				m=new Message("Question created successfully! ");
			}
		service2.save(question);
		return m;
	}
	
	//delete a question
	@CrossOrigin
	@PostMapping("/questions/delete")
	public Message deleteQuestion (@Valid @RequestBody Questions question) { 
		service2.delete(question);
		return new Message("Question deleted successfully! ");
	}
	
	
	
}
