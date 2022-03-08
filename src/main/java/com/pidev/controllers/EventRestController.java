package com.pidev.controllers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidev.models.Event;
import com.pidev.models.User;
import com.pidev.repository.EventRepository;
import com.pidev.service.MatchingAlgorithmEvent;
import com.pidev.serviceInterface.IEventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags ="EventManagement")
@RestController
@RequestMapping("/Event")
public class EventRestController {

	@Autowired
	IEventService EventService;
	@Autowired
	MatchingAlgorithmEvent algorithmEvent;
	
	@ApiOperation(value = "Add Event")
	@PostMapping("/add-event")
	@ResponseBody	
	public void addEvent(@RequestBody Event event) {
		 EventService.addEvent(event );		

	}

	
	@GetMapping("/list-events")
	@ResponseBody
	public List<Event> ListEvents()
	{
		return EventService.retrieveEvents();
	}
	@PutMapping("/update-event{idE}/{capacity}/{infos}/{name}/{prog}")
	@ResponseBody
	@JsonIgnore
	public void updateEvent( @PathVariable Long idE,@PathVariable Long capacity, /*@PathVariable Date dateE,*/
			@PathVariable String infos,@PathVariable String name,@PathVariable String prog)
	{
		EventService.AlterEvent( idE,capacity,infos,name,prog);
	}
	
	@DeleteMapping("delete-event{idE}")
	@ResponseBody
	public void DeleteEvent(@PathVariable long idE)
	{
		EventService.deleteEvent(idE);
	}
	
	@GetMapping("suggest-event/{iduser}")
	@ResponseBody
	public ResponseEntity<Set<Event>> suggestEvent(@PathVariable("iduser") long iduser){
		return ResponseEntity.ok(algorithmEvent.getAlltheEvent(iduser));
	}
	
	
	@PutMapping("/assignUser-to-event/{idUser}/{idEvent}")
	@ResponseBody
	public void AssignUsertoEvent(@PathVariable("idUser") 
	long idUser,@PathVariable("idEvent") long idEvent) {
		EventService.AssignUsertoEvent(idUser, idEvent);
	}
	
	
	/*@GetMapping("/suggest-event/{userId}")
	@ResponseBody
	public Set<Event> suggestEvent(@PathVariable("userId") long userId)
	{
		return EventService.findInterestEvent(userId); 
	}*/
	
	
	@GetMapping("/trending-event")
	@ResponseBody
	public  Event TrendingEvent()
	{
		return EventService.getTrendingEvent();
	}
	
	
}
