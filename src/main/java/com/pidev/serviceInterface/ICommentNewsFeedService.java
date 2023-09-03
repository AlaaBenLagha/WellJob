package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.CommentNewsFeed;
import com.pidev.models.PostNewsFeed;

public interface ICommentNewsFeedService {
	List<CommentNewsFeed> getAllComments(Long idPost);
	CommentNewsFeed addComment(CommentNewsFeed comment, Long idPost);
	void deleteComment(Long id);
	CommentNewsFeed updateComment(CommentNewsFeed comment , Long id);
	CommentNewsFeed getComment(Long id);

}
