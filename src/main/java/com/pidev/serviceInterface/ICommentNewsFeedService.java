package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.CommentNewsFeed;

public interface ICommentNewsFeedService {
	List<CommentNewsFeed> getAllComments();
	CommentNewsFeed addComment(CommentNewsFeed comment);
	void deleteComment(Long id);
	CommentNewsFeed updateComment(CommentNewsFeed comment , Long id);
	CommentNewsFeed getComment(Long id);

}
