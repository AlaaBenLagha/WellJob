package com.pidev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	public User findByUsername1(String username);
//
//	User findByUsername(User username);
	
	Optional<User> findByUsername(String username);
	
	
	User findByEmail(String email);

    void deleteByEmail(String email);



}
