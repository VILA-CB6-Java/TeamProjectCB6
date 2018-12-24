package com.cb6.project.examactionsservice.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cb6.project.examactionsservice.questions.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer>{
	@Query("SELECT u FROM Questions u order by function('RAND')")
	Page<Questions> findRandom(Pageable pageable);
}
