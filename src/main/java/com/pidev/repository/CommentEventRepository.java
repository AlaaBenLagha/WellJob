package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.CommentEvent;




@Repository
public interface CommentEventRepository extends CrudRepository<CommentEvent, Long> {

}
