package com.pidev.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pidev.models.NotificationEmail;
import com.pidev.models.Question;
import com.pidev.models.Quiz;
import com.pidev.models.QuizResultResponse;
import com.pidev.models.User;
import com.pidev.repository.QuestionRepository;
import com.pidev.serviceInterface.QuestionService;
import com.sun.mail.iap.Response;




@Service
public class QuesServiceImpl implements QuestionService {

	@Autowired 
	private QuestionRepository questionRepository;
	
	@Autowired 
	private MailService mailService;
	

	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {

		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Set<Question> questionsOfQuiz(Quiz quiz) {

		
		return new HashSet<>(this.questionRepository.findByQuiz(quiz));
	}

	@Override
	public void deletequestion(Long quesId) throws Exception {
		Question question=this.questionRepository.findById(quesId).get();
		if(question==null) {
			throw new Exception("Question is not found please enter valid ques id");
		}
		this.questionRepository.deleteById(quesId);

	}

	@Override
	public Question getQuestionById(Long quesId) throws Exception {
		Question question=this.questionRepository.findById(quesId).get();
		if(question==null) {
			throw new Exception("Question is not found please enter valid ques id");
		}
		return question;
	}

	
	@Override
	public void sendQuizNotifcation(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }

	

	

	
	
	


	

}
