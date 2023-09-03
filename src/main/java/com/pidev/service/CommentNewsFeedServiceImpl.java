package com.pidev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.CommentNewsFeed;
import com.pidev.models.PostNewsFeed;
import com.pidev.repository.CommentNewsFeedRepository;
import com.pidev.repository.PostNewsFeedRepository;
import com.pidev.serviceInterface.ICommentNewsFeedService;

@Service
public class CommentNewsFeedServiceImpl implements ICommentNewsFeedService{
	@Autowired
	CommentNewsFeedRepository commentNewsFeedRepository;

	@Autowired
	PostNewsFeedRepository postNewsFeedRepository;
	
	@Override
	public List<CommentNewsFeed> getAllComments(Long idPost) {
		Optional<PostNewsFeed> p = postNewsFeedRepository.findById(idPost);
		List<CommentNewsFeed> lcomment = new ArrayList<>(p.get().getCommentNewsFeeds());
		return lcomment;
	}

	@Override
	public CommentNewsFeed addComment(CommentNewsFeed comment, Long idPost) {
		comment.setPostNewsFeed(postNewsFeedRepository.findById(idPost).get());
		commentNewsFeedRepository.save(comment);
		return comment;
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
