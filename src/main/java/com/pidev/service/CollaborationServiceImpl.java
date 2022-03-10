package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.CollaborationRepository;
import com.pidev.serviceInterface.ICollaborationService;

@Service
public class CollaborationServiceImpl implements ICollaborationService{
	@Autowired
	CollaborationRepository collaborationRepository;

}
