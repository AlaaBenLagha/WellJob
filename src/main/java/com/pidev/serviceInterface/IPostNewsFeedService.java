package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.PostNewsFeed;

public interface IPostNewsFeedService {
	List<PostNewsFeed> getAllPosts();
	PostNewsFeed addPost(PostNewsFeed post);
	void deletePost(Long id);
	PostNewsFeed updatePost(PostNewsFeed post , Long id);
	PostNewsFeed getPost(Long id);

}
