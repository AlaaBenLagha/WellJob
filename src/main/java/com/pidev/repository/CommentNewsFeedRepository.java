package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.CommentNewsFeed;

@Repository
public interface CommentNewsFeedRepository extends CrudRepository<CommentNewsFeed,Long>{

}
