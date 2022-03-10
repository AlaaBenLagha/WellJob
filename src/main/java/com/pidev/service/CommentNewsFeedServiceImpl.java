package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.CommentNewsFeedRepository;
import com.pidev.serviceInterface.ICommentNewsFeedService;

@Service
public class CommentNewsFeedServiceImpl implements ICommentNewsFeedService{
	@Autowired
	CommentNewsFeedRepository commentNewsFeedRepository;

}
