package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.VoteBadge;



@Repository
public interface VoteBadgeRepository extends CrudRepository<VoteBadge,Long> {

}
