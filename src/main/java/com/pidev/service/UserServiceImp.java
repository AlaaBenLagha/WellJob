package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.IUserService;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	UserRepository userRepository;
}
