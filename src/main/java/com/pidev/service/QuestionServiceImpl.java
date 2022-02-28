package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.QuestionRepository;
import com.pidev.serviceInterface.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService   {
	@Autowired
	QuestionRepository questionRepository;
}
