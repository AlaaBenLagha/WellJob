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


import com.pidev.models.CommentArticle;
import com.pidev.serviceInterface.ICommentArticleService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;


//@Api(tags ="Gestion Comment-Article")
@RestController
@RequestMapping("/commentarticle")
public class CommentArticleRestController {
	
	@Autowired
	ICommentArticleService commentArticleService ;
	
	
	//@ApiOperation(value = "Récupérer la liste des Commentaires")
	@GetMapping("/retrieve-all-Commentaires")
	@ResponseBody
	public List<CommentArticle> GetComment() {
		return commentArticleService.retrieveAllComments();

	}
	
	//@ApiOperation(value = "Récupérer Commentaire par id")
	@GetMapping("/retrieve-commentaire-by-id/{id}")
	@ResponseBody
	public CommentArticle GetCommentaireById(@PathVariable("id")  Long IdComment) {
		return commentArticleService.retrieveCommentById(IdComment);
	}

	//@ApiOperation(value = "Ajouter Commentaire")
	@PostMapping("/add-commentaire/{article}/{user}")
	@ResponseBody	
	public CommentArticle addComment(@RequestBody CommentArticle Comment ,@PathVariable("article") Long IdArticle ,  @PathVariable("user") Long IdUser ) {
		return commentArticleService.addComment(Comment,IdArticle,IdUser);			

	}
	
	//@ApiOperation(value = "Effacer Commentaire")
	@DeleteMapping("/remove-commentaire/{id}")
	@ResponseBody
	public void removeComment(@PathVariable("id")  Long IdComment) {
		commentArticleService.deleteComment(IdComment);

	}
	
	
	//@ApiOperation(value = "Modifier Commentaire")
	@PutMapping("/modify-commentaire/{id}")
	@ResponseBody
	public CommentArticle modifyCommentaire(@RequestBody CommentArticle Comment, @PathVariable("id")  Long IdComment) {
		return commentArticleService.updateComment(IdComment, Comment);

	}

}
