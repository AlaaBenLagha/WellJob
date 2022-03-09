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

import com.pidev.models.Articles;
import com.pidev.serviceInterface.IArticlesService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;






//@Api(tags ="Gestion Article")
@RestController
@RequestMapping("/article")
public class ArticleRestController {
	
	@Autowired
	IArticlesService articlesService;
	
	
	//@ApiOperation(value = "Récupérer la liste des articles")
	@GetMapping("/retrieve-all-articles")
	@ResponseBody
	public List<Articles> GetArticles() {
		return articlesService.retrieveAllArticles();

	}
	
	//@ApiOperation(value = "Récupérer article par id")
	@GetMapping("/retrieve-article-by-id/{id}")
	@ResponseBody
	public Articles GetArticleById(@PathVariable("id")  Long IdArticle) {
		return articlesService.retrieveArticle(IdArticle);

	}

	//@ApiOperation(value = "Ajouter Article")
	@PostMapping("/add-article/{user}")
	@ResponseBody	
	public Articles addArticle(@RequestBody Articles Article ,@PathVariable("user") Long IdUser) {
		return articlesService.addArticle(Article, IdUser );		

	}
	
	//@ApiOperation(value = "Effacer Article")
	@DeleteMapping("/remove-article/{id}")
	@ResponseBody
	public void removeArticle(@PathVariable("id")  Long IdArticle) {
		articlesService.deleteArticle(IdArticle);

	}
	
	
	//@ApiOperation(value = "Modifier Article")
	@PutMapping("/modify-article/{id}")
	@ResponseBody
	public Articles modifyArticle(@RequestBody Articles Article, @PathVariable("id")  Long IdArticle) {
		return articlesService.updateArticle(Article, IdArticle);

	}
	
	
}
