package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.VoteBadgeRepository;
import com.pidev.serviceInterface.IVoteBadgeService;

@Service
public class VoteBadgeServiceImpl implements IVoteBadgeService {
	
	@Autowired
	VoteBadgeRepository badgeRepository;

}
