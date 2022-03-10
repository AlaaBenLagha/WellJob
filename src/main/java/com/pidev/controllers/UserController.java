package com.pidev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pidev.models.User;
import com.pidev.service.VoteService;
import com.pidev.serviceInterface.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return this.userService.findUser(username);
	}

	
	@ResponseBody
	public String deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
		return "user with userid "+userId+" is deleted successfully";
	}

}
