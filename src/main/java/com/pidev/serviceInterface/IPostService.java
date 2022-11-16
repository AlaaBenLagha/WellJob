package com.pidev.serviceInterface;


import com.pidev.models.Post;


public interface IPostService {
	
	Iterable<Post> listAllPosts();
	void savePost(Post post);
	Post getPostById(Long id);





}
