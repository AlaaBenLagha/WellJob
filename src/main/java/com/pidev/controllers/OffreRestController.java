package com.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.models.Offre;
import com.pidev.serviceInterface.IOffreService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/offre")
public class OffreRestController {

	@Autowired
	IOffreService offreService;
	
			//http://localhost:8082/SpringMVC/offre/addoffre
			@PostMapping("/addoffre")
			@ResponseBody	
			public Offre addOffre(@RequestBody Offre offre) {
				return offreService.addOffre(offre);		

			}
			
			//http://localhost:8082/SpringMVC/offre/getoffre/
			@GetMapping("/getoffre/{id}")
			@ResponseBody
			public Offre GetOffre(@PathVariable("id")  Long id) {
				return offreService.retrieveOffre(id);

			}
			
			//http://localhost:8082/SpringMVC/offre/getalloffres
			@GetMapping("/getalloffres")
			@ResponseBody
			public List<Offre> GetOffres() {
				return offreService.getAllOffres();

			}
			
			//http://localhost:8082/SpringMVC/offre/deleteoffre/
			@DeleteMapping("/deleteoffre/{id}")
			@ResponseBody
			public void removeOffre(@PathVariable("id")  Long id) {
				offreService.deleteOffre(id);

			}
			
			//http://localhost:8082/SpringMVC/offre/updateoffre/
			@PutMapping("/updateoffre/{id}")
			@ResponseBody
			public Offre updateOffre(@RequestBody Offre offre, @PathVariable("id")  Long id) {
				return offreService.updateOffre(offre, id);

			}

}
