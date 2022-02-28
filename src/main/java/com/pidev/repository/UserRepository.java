package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
