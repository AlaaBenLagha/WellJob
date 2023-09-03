package com.pidev.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pidev.models.PostNewsFeed;
import com.pidev.models.User;
import com.pidev.repository.PostNewsFeedRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.IPostNewsFeedService;

@Service
public class PostNewsFeedServiceImpl implements IPostNewsFeedService{
	@Autowired
	PostNewsFeedRepository postNewsFeedRepository;
	@Autowired
	UserRepository userRepository;

	
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

	@Override
	public void saveImage(MultipartFile image) throws Exception{
		String folder="/photos/";
		byte[] bytes = image.getBytes();
		Path path = Paths.get(folder + image.getOriginalFilename());
		Files.write(path, bytes);
		
	}

	@Override
	public List<PostNewsFeed> getPostsByUser(Long idUser) {
		User user = userRepository.findById(idUser).orElse(null);
		return postNewsFeedRepository.findByUser(user);
	}

	@Override
	public List<PostNewsFeed> getPostByTitle(String TitlePost) {
		return postNewsFeedRepository.findPostByTitle(TitlePost);
	}

	

}
