package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.MessageRepository;
import com.pidev.serviceInterface.IMessageService;

@Service
public class MessageServiceImp implements IMessageService {

	@Autowired
	MessageRepository messageRepository;
}
