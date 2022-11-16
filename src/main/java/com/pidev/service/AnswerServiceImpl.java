package com.pidev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Answer;
import com.pidev.models.User;
import com.pidev.repository.AnswerRepo;
import com.pidev.serviceInterface.IAnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private AnswerRepo questionsAnswerRepo;

    @Override
    public List<Answer> getAllQuestionAnswer() {
        return questionsAnswerRepo.findAll();
    }

    @Override
    public List<Answer> getAllUserQuestionAnswer(User user) {
        return questionsAnswerRepo.findByUser(user);
    }

    @Override
    public void saveAnswerofQuestion(Answer answer) {
        questionsAnswerRepo.save(answer);
    }




}
