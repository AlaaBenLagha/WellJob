package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Articles;


@Repository
public interface ArticlesRepository extends CrudRepository<Articles,Long> {

}
