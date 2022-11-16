package com.pidev.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Question;
import com.pidev.models.User;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	

	@Override
	public User createUser(User user){
		
		User theUser=this.userRepository.findByUsername(user.getUsername()).orElse(null);		
		
		
		return theUser;
	}
	@Override
    public User findUser(String username) {
		
		return this.userRepository.findByUsername(username).orElse(null);
	}
	@Override
	public void deleteUser(Long id) {
		
		 this.userRepository.deleteById(id);
	}
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public void deleteTheUser(String email) {
		userRepository.deleteByEmail(email);
		
	}
	@Override
	public void addUser(User user) {
		userRepository.save(user);
		
	}

	
	

	
	

	


   

	

	

	

}