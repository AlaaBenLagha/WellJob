package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.CommentArticleRepository;
import com.pidev.serviceInterface.ICommentArticleService;

@Service
public class CommentArticleServiceImpl implements ICommentArticleService {
	@Autowired
	CommentArticleRepository commentArticleRepository;
}
