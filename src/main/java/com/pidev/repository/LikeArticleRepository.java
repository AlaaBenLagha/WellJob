package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.LikeArticle;

@Repository
public interface LikeArticleRepository extends CrudRepository<LikeArticle,Long> {

}
