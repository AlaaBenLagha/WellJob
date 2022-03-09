package com.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Badge;

@Repository
public interface BadgeRepository extends CrudRepository<Badge, Long>{

}
