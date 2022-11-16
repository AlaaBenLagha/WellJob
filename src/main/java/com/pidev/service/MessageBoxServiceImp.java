package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.MessageBoxRepository;
import com.pidev.serviceInterface.IMesssageBoxService;

@Service
public class MessageBoxServiceImp implements IMesssageBoxService {

	@Autowired
	MessageBoxRepository messageBoxRepository;
}
