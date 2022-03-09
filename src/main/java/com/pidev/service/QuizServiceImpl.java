package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.QuizRepository;
import com.pidev.serviceInterface.IQuizService;

@Service
public class QuizServiceImpl implements IQuizService {
	
	@Autowired
	QuizRepository quizRepository;
}
