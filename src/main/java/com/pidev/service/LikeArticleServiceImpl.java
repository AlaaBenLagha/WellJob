package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.LikeArticleRepository;
import com.pidev.serviceInterface.ILikeArticleService;

@Service
public class LikeArticleServiceImpl implements ILikeArticleService {
	@Autowired
	LikeArticleRepository likeArticleRepository;
}
