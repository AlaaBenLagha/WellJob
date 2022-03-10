package com.pidev.serviceInterface;

import com.pidev.models.*;


import java.util.List;

public interface IAnswerService {
    List<Answer> getAllQuestionAnswer();
    List<Answer> getAllUserQuestionAnswer(User user);
    void saveAnswerofQuestion(Answer answer);
//    public Answer GetAnswerById(Long id);
}
