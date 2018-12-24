package com.cb6.project.examactionsservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cb6.project.examactionsservice.exam.Exams;

public interface ExamsRepository extends JpaRepository<Exams, String>{
	List<Exams>findAllByUserId(Integer userId);
}
