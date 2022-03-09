package com.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.models.PostNewsFeed;
import com.pidev.serviceInterface.IPostNewsFeedService;

@RestController
@RequestMapping("/post")
public class PostNewsFeedRestController {
	
	@Autowired
	IPostNewsFeedService postService;
	
			//http://localhost:8082/SpringMVC/post/addpost
			@PostMapping("/addpost")
			@ResponseBody	
			public PostNewsFeed addPost(@RequestBody PostNewsFeed post) {
				return postService.addPost(post);		

			}
			
			//http://localhost:8082/SpringMVC/post/getpost/
			@GetMapping("/getpost/{id}")
			@ResponseBody
			public PostNewsFeed getPost(@PathVariable("id")  Long id) {
				return postService.getPost(id);

			}
			
			//http://localhost:8082/SpringMVC/post/getallposts
			@GetMapping("/getallposts")
			@ResponseBody
			public List<PostNewsFeed> getPosts() {
				return postService.getAllPosts();

			}
			
			//http://localhost:8082/SpringMVC/post/deletepost/
			@DeleteMapping("/deletepost/{id}")
			@ResponseBody
			public void deletePost(@PathVariable("id")  Long id) {
				postService.deletePost(id);

			}
			
			//http://localhost:8082/SpringMVC/post/updatepost/
			@PutMapping("/updatepost/{id}")
			@ResponseBody
			public PostNewsFeed updatePost(@RequestBody PostNewsFeed post, @PathVariable("id")  Long id) {
				return postService.updatePost(post, id);

			}

}
