package com.pidev.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Articles;
//import com.pidev.models.LikeArticle;
import com.pidev.models.User;
import com.pidev.repository.ArticlesRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.IArticlesService;


@Service
public class ArticlesServiceImpl implements IArticlesService {
	@Autowired
	ArticlesRepository articlesRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Articles> retrieveAllArticles() {
		return (List<Articles>) articlesRepository.findAll();
	}

	@Transactional
	public Articles addArticle(Articles Article, Long IdUser) {
		User user = userRepository.findById(IdUser).orElse(null);
		Article.setUser(user);
//		LikeArticle likeArticle = Article.getLikeArticle();
//		likeArticle.setArticles(Article);
		return articlesRepository.save(Article);
	}

	@Override
	public void deleteArticle(Long IdArticle) {
		articlesRepository.deleteById(IdArticle);
		
	}

	@Transactional
	public Articles updateArticle(Articles Article , Long IdArticle) {
		Article.setIdArticle(IdArticle);
		return articlesRepository.save(Article);
	}

	@Override
	public Articles retrieveArticle(Long IdArticle) {
		return articlesRepository.findById(IdArticle).get();
	}

	

	
	
	
}
