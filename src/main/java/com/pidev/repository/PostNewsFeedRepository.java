package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.PostNewsFeed;

@Repository
public interface PostNewsFeedRepository extends CrudRepository<PostNewsFeed,Long>{

}
