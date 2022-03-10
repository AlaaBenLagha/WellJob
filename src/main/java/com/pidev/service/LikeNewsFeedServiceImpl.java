package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.LikeNewsFeedRepository;
import com.pidev.serviceInterface.ILikeNewsFeedService;

@Service
public class LikeNewsFeedServiceImpl implements ILikeNewsFeedService{
	@Autowired
	LikeNewsFeedRepository likeNewsFeedRepository;

}
