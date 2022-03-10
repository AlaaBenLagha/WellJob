package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.EventRepository;
import com.pidev.serviceInterface.IEventService;

@Service
public class EventServiceImpl  implements IEventService{
	@Autowired
	EventRepository eventRepository;

}
