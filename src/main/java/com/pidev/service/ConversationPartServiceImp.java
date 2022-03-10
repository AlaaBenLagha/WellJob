package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.ConversationPartRepository;
import com.pidev.serviceInterface.IConversationPartService;

@Service
public class ConversationPartServiceImp implements IConversationPartService {

	@Autowired
	ConversationPartRepository conversationPartRepository;
}
