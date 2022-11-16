package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Event;


@Repository
public interface EventRepository extends CrudRepository<Event,Long> {

}
