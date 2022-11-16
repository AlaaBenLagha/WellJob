package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.AttemptedQuiz;
import com.pidev.models.User;
import com.pidev.repository.AttemptedQuizRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.IAttemptedQuizService;
import com.pidev.serviceInterface.QuizService;
import com.pidev.serviceInterface.UserService;



@Service
public class AttemptedQuizServiceImpl implements IAttemptedQuizService {
	
	
	@Autowired
	private AttemptedQuizRepository attemptedQuizRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	

}
