package com.pidev.serviceInterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pidev.models.Collaboration;
import com.pidev.models.PostNewsFeed;

public interface IPostNewsFeedService {
	List<PostNewsFeed> getAllPosts();
	PostNewsFeed addPost(PostNewsFeed post);
	void deletePost(Long id);
	PostNewsFeed updatePost(PostNewsFeed post , Long id);
	PostNewsFeed getPost(Long id);
	void saveImage(MultipartFile image) throws Exception;
	List<PostNewsFeed> getPostsByUser(Long idUser);
	List<PostNewsFeed> getPostByTitle(String TitlePost);

}
