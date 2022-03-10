package com.pidev.serviceInterface;

import java.util.Set;

import com.pidev.dto.PostResponse;
import com.pidev.models.Post;


public interface IPostService {
	
	Iterable<Post> listAllPosts();
	void savePost(Post post);
	Post getPostById(Long id);





}
