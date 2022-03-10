package com.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
