package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
