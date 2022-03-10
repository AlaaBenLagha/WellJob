package com.pidev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.models.Ask;
import com.pidev.models.Question;
import com.pidev.models.User;
import com.pidev.repository.AskRepo;
import com.pidev.serviceInterface.IAskService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AskServiceImpl implements IAskService {

    @Autowired
    private AskRepo askRepo;

	@Override
	public List<Ask> getUserQuestions(User user) {
		return askRepo.findByUser(user);
	}

	@Override
	public int getNumberOfQuestionsPerUser(User user) {
		return askRepo.countAllByUser(user);
		
	}

	@Override
	public void deleteAllUserQuestion(User user) {
		askRepo.deleteAllByUser(user) ;
		
	}

	@Override
	public void deleteOneUserQuestion(Long id) {
		askRepo.deleteById(id);
		
	}

	@Override
	public void saveQuestion(Ask ask) {
		askRepo.save(ask);
		
	}

	@Override
	public Ask getAskById(Long id) {
		return askRepo.getById(id);
	}



	

   

//    @Override
//    public void deleteUserFromQuestin(Long id) {
//        questionRepo.deleteUserFromQuestons(id);
//    }


}
