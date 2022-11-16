package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.PostNewsFeedRepository;
import com.pidev.serviceInterface.IPostNewsFeedService;

@Service
public class PostNewsFeedServiceImpl implements IPostNewsFeedService{
	@Autowired
	PostNewsFeedRepository postNewsFeedRepository;

}
