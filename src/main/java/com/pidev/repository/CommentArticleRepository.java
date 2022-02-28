package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.CommentArticle;



@Repository
public interface CommentArticleRepository extends CrudRepository<CommentArticle,Long> {

}
