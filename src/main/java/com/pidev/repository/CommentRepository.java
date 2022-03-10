package com.pidev.repository;

import com.pidev.models.Comment;
import com.pidev.models.Post;
import com.pidev.models.Subreddit;
import com.pidev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    
    List<Comment> findAllByUser(User user);
}