package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {

}
