package com.pidev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Articles;
import com.pidev.models.CommentArticle;
import com.pidev.models.User;
import com.pidev.repository.ArticlesRepository;
import com.pidev.repository.CommentArticleRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.ICommentArticleService;


@Service
public class CommentArticleServiceImpl implements ICommentArticleService {
	@Autowired
	CommentArticleRepository commentArticleRepository;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public List<CommentArticle> retrieveAllComments() {
		return (List<CommentArticle>) commentArticleRepository.findAll();
	}

	@Transactional
	public CommentArticle addComment(CommentArticle Comment, Long IdArticle, Long IdUser) {
		// TODO Auto-generated method stub
		Articles articles = articlesRepository.findById(IdArticle).orElse(null);
		User user = userRepository.findById(IdUser).orElse(null);
//		Comment.setArticles(articles);
//		Comment.setUser(user);
		return commentArticleRepository.save(Comment);
	}

	@Override
	public void deleteComment(Long IdComment) {
		commentArticleRepository.deleteById(IdComment);
		
	}

	@Override
	public CommentArticle updateComment(Long IdComment,CommentArticle Comment) {
//		CommentArticle comment = commentArticleRepository.findById(IdComment).orElse(null);
		Comment.setIdComment(IdComment);
		return commentArticleRepository.save(Comment);
	}

	@Override
	public CommentArticle retrieveCommentById(Long IdComment) {
		return commentArticleRepository.findById(IdComment).get();
	}
}
