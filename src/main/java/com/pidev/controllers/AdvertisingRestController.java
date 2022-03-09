package com.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.models.Advertising;
import com.pidev.serviceInterface.IAdvertisingService;

@RestController
@RequestMapping("/advertising")
public class AdvertisingRestController {
	
	@Autowired
	IAdvertisingService advertisingService;
	
			//http://localhost:8082/SpringMVC/advertising/addadvertising
			@PostMapping("/addadvertising")
			@ResponseBody	
			public Advertising addCollab(@RequestBody Advertising ad) {
				return advertisingService.addAdvertising(ad);		

			}
			
			//http://localhost:8082/SpringMVC/advertising/getadvertising/
			@GetMapping("/getadvertising/{id}")
			@ResponseBody
			public Advertising GetAdvertising(@PathVariable("id")  Long id) {
				return advertisingService.getAdvertising(id);

			}
			
			//http://localhost:8082/SpringMVC/advertising/getalladvertisings
			@GetMapping("/getalladvertisings")
			@ResponseBody
			public List<Advertising> GetAdvertisings() {
				return advertisingService.getAllAdvertising();

			}
			
			//http://localhost:8082/SpringMVC/advertising/deleteadvertising/
			@DeleteMapping("/deleteadvertising/{id}")
			@ResponseBody
			public void deleteAdvertising(@PathVariable("id")  Long id) {
				advertisingService.deleteAdvertising(id);

			}
			
			//http://localhost:8082/SpringMVC/advertising/updateadvertising/
			@PutMapping("/updateadvertising/{id}")
			@ResponseBody
			public Advertising updateAdvertising(@RequestBody Advertising ad, @PathVariable("id")  Long id) {
				return advertisingService.updateAdvertising(ad, id);

			}
			
			//http://localhost:8082/SpringMVC/advertising/getadvertisingbytitle/
			@GetMapping("/getadvertisingbytitle/{title_ad}")
			@ResponseBody
			public List<Advertising> retrieveAdvertisingByTitle(@PathVariable("title_ad") String adTitle) {
				return advertisingService.retrieveAdvertisingByTitle(adTitle);
				
			}

}
