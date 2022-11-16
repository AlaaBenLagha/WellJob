package com.pidev.serviceInterface;

import java.util.List;
import java.util.Set;


import com.pidev.models.Category;
import com.pidev.models.Quiz;



public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuizById(Long qid) throws Exception;
	
	public void deleteQuiz(Long qid) throws Exception;

	public List<Quiz> findQuizzesByCategoryId(Category category);
	
	public List<Quiz> findAllActiveQuiz();
	
	public List<Quiz> findAllActiveQuizOfCategory(Category category);

}
