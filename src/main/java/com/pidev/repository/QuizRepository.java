package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Quiz;


@Repository
public interface QuizRepository extends CrudRepository<Quiz,Long> {

}
