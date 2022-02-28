package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.FeedBack;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBack,Long> {

}
