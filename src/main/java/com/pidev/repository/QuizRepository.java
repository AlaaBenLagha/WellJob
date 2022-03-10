package com.pidev.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Category;
import com.pidev.models.Quiz;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findQuizzesByCategory(Category category);
	
	List<Quiz> findByActive(boolean active);
	
	List<Quiz> findByCategoryAndActive(Category category, boolean active);
}
