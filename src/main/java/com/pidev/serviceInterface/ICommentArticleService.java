package com.pidev.serviceInterface;

import java.util.List;


import com.pidev.models.CommentArticle;

public interface ICommentArticleService {
	
	
	List<CommentArticle> retrieveAllComments();
	CommentArticle addComment(CommentArticle Comment, Long IdArticle , Long IdUser);
	void deleteComment(Long IdComment);
	CommentArticle updateComment(Long IdComment, CommentArticle Comment);
	CommentArticle retrieveCommentById(Long IdComment);

}
