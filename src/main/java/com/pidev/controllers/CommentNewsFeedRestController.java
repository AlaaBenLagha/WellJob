package com.pidev.controllers;

import java.util.Date;
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
import com.pidev.repository.CommentNewsFeedRepository;
import com.pidev.service.BadWordsServiceImpl;
import com.pidev.serviceInterface.ICommentNewsFeedService;

@RestController
@RequestMapping("/commentnewsfeed")
public class CommentNewsFeedRestController {
	
	@Autowired
	ICommentNewsFeedService commentService;
	@Autowired
	BadWordsServiceImpl badwordsService;
	
		//http://localhost:8082/SpringMVC/commentnewsfeed/addcomment
			@PostMapping("/addcomment/{id}")
			@ResponseBody	
			public CommentNewsFeed addComment(@RequestBody CommentNewsFeed comment,@PathVariable("id") Long idPost) {
				String input= comment.getContentComment();
				String output = badwordsService.getCensoredText(input);
				comment.setContentComment(output);
				comment.setDateComment(new Date());
				return commentService.addComment(comment, idPost);		
			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/getcomment/
			@GetMapping("/getcomment/{id}")
			@ResponseBody
			public CommentNewsFeed GetComment(@PathVariable("id")  Long id) {
				return commentService.getComment(id);

			}
			
			//http://localhost:8082/SpringMVC/commentnewsfeed/getallcomments
			@GetMapping("/getallcomments/{id}")
			@ResponseBody
			public List<CommentNewsFeed> GetComments(@PathVariable("id") Long idPost) {
				return commentService.getAllComments(idPost);

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
