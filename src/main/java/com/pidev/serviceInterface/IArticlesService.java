package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.Articles;







public interface IArticlesService {

	
	List<Articles> retrieveAllArticles();
	Articles addArticle(Articles Article, Long IdUser);
	void deleteArticle(Long IdArticle);
	Articles updateArticle(Articles Article , Long IdArticle);
	Articles retrieveArticle(Long IdArticle);
}
