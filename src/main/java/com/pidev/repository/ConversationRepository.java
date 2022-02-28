package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Conversation;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long> {

}
