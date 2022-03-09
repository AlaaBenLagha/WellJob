package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.CommentNewsFeed;
import com.pidev.repository.CommentNewsFeedRepository;
import com.pidev.serviceInterface.ICommentNewsFeedService;

@Service
public class CommentNewsFeedServiceImpl implements ICommentNewsFeedService{
	@Autowired
	CommentNewsFeedRepository commentNewsFeedRepository;

	@Override
	public List<CommentNewsFeed> getAllComments() {
		return (List<CommentNewsFeed>) commentNewsFeedRepository.findAll();
	}

	@Override
	public CommentNewsFeed addComment(CommentNewsFeed comment) {
		return commentNewsFeedRepository.save(comment);
	}

	@Override
	public void deleteComment(Long id) {
		commentNewsFeedRepository.deleteById(id);
		
	}

	@Override
	public CommentNewsFeed updateComment(CommentNewsFeed comment, Long id) {
		comment.setIdComment(id);
		return commentNewsFeedRepository.save(comment);
	}

	@Override
	public CommentNewsFeed getComment(Long id) {
		return commentNewsFeedRepository.findById(id).get();
	}

	

}
