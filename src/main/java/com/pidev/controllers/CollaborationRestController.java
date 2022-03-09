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


import com.pidev.models.Collaboration;
import com.pidev.serviceInterface.ICollaborationService;
import javax.validation.Valid;

@RestController
@RequestMapping("/collaboration")
public class CollaborationRestController {
	
	@Autowired
	ICollaborationService collaborationService;
	
		//http://localhost:8082/SpringMVC/collaboration/addcollab
		@PostMapping("/addcollab")
		@ResponseBody	
		public void addCollab(@Valid @RequestBody Collaboration collaboration) {
			collaborationService.addCollaboration(collaboration);		

		}
		
		//http://localhost:8082/SpringMVC/collaboration/getallcollaborations
		@GetMapping("/getallcollaborations")
		@ResponseBody
		public List<Collaboration> GetCollaboration() {
			return collaborationService.GetAllCollaborations();

		}
		
		//http://localhost:8082/SpringMVC/collaboration/getcollaboration/
		@GetMapping("/getcollaboration/{id}")
		@ResponseBody
		public Collaboration GetCollaboration(@PathVariable("id")  Long id) {
			return collaborationService.getCollaboration(id);

		}
		
		//http://localhost:8082/SpringMVC/collaboration/deletecollaboration/
		@DeleteMapping("/deletecollaboration/{id}")
		@ResponseBody
		public void deleteCollaboration(@PathVariable("id")  Long id) {
			collaborationService.deleteCollaboration(id);

		}
		
		//http://localhost:8082/SpringMVC/collaboration/updatecollaboration/
		@PutMapping("/updatecollaboration/{id}")
		@ResponseBody
		public Collaboration updateCollaboration(@RequestBody Collaboration collaboration, @PathVariable("id")  Long id) {
			return collaborationService.updateCollaboration(collaboration, id);

		}

}
