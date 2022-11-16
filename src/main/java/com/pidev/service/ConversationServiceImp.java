package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.ConversationRepository;
import com.pidev.serviceInterface.IConversationService;

@Service
public class ConversationServiceImp implements IConversationService {

	@Autowired
	ConversationRepository conversationRepository;
}
