package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.ConversationPart;

@Repository
public interface ConversationPartRepository extends CrudRepository<ConversationPart, Long> {

}
