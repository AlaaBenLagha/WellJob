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

import com.pidev.models.CommentNewsFeed;
import com.pidev.serviceInterface.ICommentNewsFeedService;

@RestController
@RequestMapping("/commentnewsfeed")
public class CommentNewsFeedRestController {
	
	@Autowired
	ICommentNewsFeedService commentService;
	
		//http://localhost:8082/SpringMVC/commentnewsfeed/addcomment
			@PostMapping("/addcomment")
			@ResponseBody	
			public CommentNewsFeed addComment(@RequestBody CommentNewsFeed comment) {
				return commentService.addComment(comment);		

			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/getcomment/
			@GetMapping("/getcomment/{id}")
			@ResponseBody
			public CommentNewsFeed GetComment(@PathVariable("id")  Long id) {
				return commentService.getComment(id);

			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/getallcomments
			@GetMapping("/getallcomments")
			@ResponseBody
			public List<CommentNewsFeed> GetComments() {
				return commentService.getAllComments();

			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/deletecomment/
			@DeleteMapping("/deletecomment/{id}")
			@ResponseBody
			public void deleteComment(@PathVariable("id")  Long id) {
				commentService.deleteComment(id);

			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/updatecomment/
			@PutMapping("/updatecomment/{id}")
			@ResponseBody
			public CommentNewsFeed updateComment(@RequestBody CommentNewsFeed comment, @PathVariable("id")  Long id) {
				return commentService.updateComment(comment, id);

			}

}
