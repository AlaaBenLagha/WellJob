package com.pidev.serviceInterface;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pidev.models.Quiz;
import com.pidev.models.User;



@Service
public interface UserService {
	
	public User createUser(User user) throws Exception;
	
	
	public User save(User user);
    
	public User findUser(String username);
	
	public void deleteUser(Long id);
	
	
	User getUserByEmail(String email);
	
    List<User> getAllUsers();
    void deleteTheUser(String email);
    void  addUser(User user);


	










	
}