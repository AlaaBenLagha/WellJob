package com.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.service.EmailService;

@RestController
public class MailSenderRestController {
	@Autowired
	private EmailService mailSender;
	
	@GetMapping("/mail")
	public void sendMail(){
		mailSender.sendSimpleMessage("fatma.naili@esprit.tn", "test", "ok");
	}

}
