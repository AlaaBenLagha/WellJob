package com.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.service.BadWordsServiceImpl;

@RestController
public class BadWordsController {
	@Autowired
	private BadWordsServiceImpl badwordService;
	
	@GetMapping("/badwords")
	public String FilterBadWords(@RequestBody String text) {
		String input= text;
		String output = badwordService.getCensoredText(input);
		return output;
	}
	
}
