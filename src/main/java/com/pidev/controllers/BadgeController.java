package com.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.models.Badge;
import com.pidev.services.IBadgeService;



@RestController
@RequestMapping("badge")
public class BadgeController {

	@Autowired
	IBadgeService badgeService;
	
	@GetMapping("/list-badges")
	@ResponseBody
 	public List<Badge> getBadgeslist (){
 		return badgeService.retriveAllBadge();
 		
 	}
 	
 	@PostMapping("/add-badge")
 	@ResponseBody
 	public  Badge addbadge(@RequestBody Badge b) {
 		Badge ba = badgeService.addBadge(b);
 		return ba;
 	    //return  new ResponseEntity<String>("add succes", HttpStatus.INTERNAL_SERVER_ERROR);
 	}
 	
 	@DeleteMapping("/delete-badge/{id}")
 	@ResponseBody
 	public void deleteBadge(@PathVariable("id") Long idbadge) {
 		badgeService.deleteBadge(idbadge);
 	}
 	
 	@PutMapping("/update-badge")
 	@ResponseBody
 	public Badge updateBadge(@RequestBody Badge b) {
 		Badge ba = badgeService.updateBadge(b);
 		return  ba;
 	}
 	
 	@PutMapping("/assyn-badge/{idb}/{idp}")
 	@ResponseBody
 	public ResponseEntity<String> assynBadge(@PathVariable("idb") Long idba,@PathVariable("idp") Long idpf) {
 		badgeService.assynBadgeToProfil(idba, idpf);
 		return  new ResponseEntity<String>("Assyn succes", HttpStatus.INTERNAL_SERVER_ERROR);
 	}
}
