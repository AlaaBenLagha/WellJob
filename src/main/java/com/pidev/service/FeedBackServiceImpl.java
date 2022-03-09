package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.FeedBackRepository;
import com.pidev.serviceInterface.IFeedBackService;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
	@Autowired
	FeedBackRepository feedBackRepository;
}
