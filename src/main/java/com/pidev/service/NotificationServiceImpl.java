package com.pidev.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.NotificationRepository;
import com.pidev.serviceInterface.INotificationService;

@Service
public class NotificationServiceImpl implements INotificationService {

	
	@Autowired
	NotificationRepository notificationRepository;
}
