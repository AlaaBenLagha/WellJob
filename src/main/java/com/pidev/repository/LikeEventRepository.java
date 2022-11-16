package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pidev.models.LikeEvent;

@Repository
public interface LikeEventRepository extends CrudRepository<LikeEvent,Long> {

}
