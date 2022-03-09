package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Collaboration;

@Repository
public interface CollaborationRepository extends CrudRepository<Collaboration,Long>{

}
