package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.CommentEventRepository;
import com.pidev.serviceInterface.ICommentEventService;
@Service
public class CommentEventServiceImpl implements ICommentEventService {
	@Autowired
	CommentEventRepository commentEventRepository; 

}
