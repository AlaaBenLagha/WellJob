package com.pidev.serviceInterface;

import com.pidev.models.*;

import java.util.List;

public interface IAskService {
    List<Ask> getUserQuestions(User user);
    int getNumberOfQuestionsPerUser(User user);
    void deleteAllUserQuestion(User user);
    void deleteOneUserQuestion(Long id );
    void  saveQuestion(Ask ask);
    
    public Ask getAskById(Long id);

//    void deleteUserFromQuestin(Long id);
}
