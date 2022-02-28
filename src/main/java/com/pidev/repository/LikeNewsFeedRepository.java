package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.LikeNewsFeed;

@Repository
public interface LikeNewsFeedRepository extends CrudRepository<LikeNewsFeed,Long>{

}
