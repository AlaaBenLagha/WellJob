package com.pidev.serviceInterface;


import java.util.Set;
import com.pidev.models.Question;
import com.pidev.models.Quiz;
import com.pidev.models.QuizResultResponse;
import com.pidev.models.User;


public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Set<Question> questionsOfQuiz(Quiz quiz);
	
	public void deletequestion(Long quesId) throws Exception;
	
	public Question getQuestionById(Long quesId) throws Exception;

	void sendQuizNotifcation(String message, User user);

	


	


}
