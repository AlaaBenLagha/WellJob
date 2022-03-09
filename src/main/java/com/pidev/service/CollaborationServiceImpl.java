package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Collaboration;
import com.pidev.models.User;
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

	
}
