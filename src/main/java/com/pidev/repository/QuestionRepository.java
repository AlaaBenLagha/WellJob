package com.pidev.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Question;
import com.pidev.models.Quiz;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	Set<Question> findByQuiz(Quiz quiz);
	


}
