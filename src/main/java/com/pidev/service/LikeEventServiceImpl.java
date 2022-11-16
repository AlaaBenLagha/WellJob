package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.LikeEventRepository;
import com.pidev.serviceInterface.ILikeEventService;
@Service
public class LikeEventServiceImpl implements ILikeEventService {
	@Autowired
	LikeEventRepository likeEventRepository; 

}
