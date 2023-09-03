package com.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.models.Collaboration;
import com.pidev.models.PostNewsFeed;
import com.pidev.models.User;


@Repository
public interface PostNewsFeedRepository extends CrudRepository<PostNewsFeed,Long>{
	List<PostNewsFeed> findByUser(User user);
	
	@Query(value="SELECT p FROM PostNewsFeed p WHERE p.TitlePost= :TitlePost", nativeQuery=false)
	List<PostNewsFeed> findPostByTitle(@Param("TitlePost") String TitlePost);
}
