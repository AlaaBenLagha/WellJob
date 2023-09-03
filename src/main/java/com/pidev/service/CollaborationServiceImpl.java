package com.pidev.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pidev.models.Collaboration;
import com.pidev.repository.CollaborationRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.ICollaborationService;

@Service
public class CollaborationServiceImpl implements ICollaborationService{
	@Autowired
	CollaborationRepository collaborationRepository;
	UserRepository userRepository;

	@Override
	public List<Collaboration> GetAllCollaborations() {
		return (List<Collaboration>) collaborationRepository.findAll();
	}

	@Override
	public void addCollaboration(Collaboration collaboration) {
		//User user = userRepository.findById(IdUser).orElse(null);
		//collaboration.setUser(user);
		collaborationRepository.save(collaboration);
	}

	@Override
	public void deleteCollaboration(Long id) {
		collaborationRepository.deleteById(id);
		
	}

	@Override
	public Collaboration updateCollaboration(Collaboration collaboration, Long id) {
		collaboration.setIdCollaboration(id);
		return collaborationRepository.save(collaboration);
	}

	@Override
	public Collaboration getCollaboration(Long id) {
		return collaborationRepository.findById(id).get();
	}

//	@Override
//	public List<Collaboration> statistic() {
//		return collaborationRepository.countTotalRateByYear();
//	}

//	@Override
//	public List<Collaboration> GetAllCollaborations(Specification<Collaboration> spec) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Collaboration> retrieveAdvertisingByEntreprise(String collaboratedWith) {
		return collaborationRepository.retrieveCollaborationByTitle(collaboratedWith);
	}

	
}