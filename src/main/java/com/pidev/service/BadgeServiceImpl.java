package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.BadgeRepository;
import com.pidev.serviceInterface.IBadgeService;

@Service
public class BadgeServiceImpl implements IBadgeService {
	
	@Autowired
	BadgeRepository badgeRepository;

}
