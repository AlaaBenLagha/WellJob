package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.PostNewsFeed;
import com.pidev.repository.PostNewsFeedRepository;
import com.pidev.serviceInterface.IPostNewsFeedService;

@Service
public class PostNewsFeedServiceImpl implements IPostNewsFeedService{
	@Autowired
	PostNewsFeedRepository postNewsFeedRepository;

	@Override
	public List<PostNewsFeed> getAllPosts() {
		return (List<PostNewsFeed>) postNewsFeedRepository.findAll();
	}

	@Override
	public PostNewsFeed addPost(PostNewsFeed post) {
		return postNewsFeedRepository.save(post);
	}

	@Override
	public void deletePost(Long id) {
		postNewsFeedRepository.deleteById(id);
		
	}

	@Override
	public PostNewsFeed updatePost(PostNewsFeed post, Long id) {
		post.setIdPost(id);
		return postNewsFeedRepository.save(post);
	}

	@Override
	public PostNewsFeed getPost(Long id) {
		return postNewsFeedRepository.findById(id).get();
	}

	

}
