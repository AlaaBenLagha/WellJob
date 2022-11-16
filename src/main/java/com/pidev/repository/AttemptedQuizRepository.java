package com.pidev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.AttemptedQuiz;

import com.pidev.models.User;


@Repository
public interface AttemptedQuizRepository extends CrudRepository<AttemptedQuiz, Long> {
	


}
