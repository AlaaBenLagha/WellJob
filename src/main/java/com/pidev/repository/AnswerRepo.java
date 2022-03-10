package com.pidev.repository;

import com.pidev.models.Answer;
import com.pidev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Long> {
    List<Answer> findByUser(User user);
}
