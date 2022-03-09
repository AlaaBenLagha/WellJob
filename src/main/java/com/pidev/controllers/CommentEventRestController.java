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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidev.models.CommentEvent;
import com.pidev.serviceInterface.ICommentEventService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags ="Event Comment Management")
@RestController
@RequestMapping("/EventComment")
public class CommentEventRestController {
	@Autowired
	ICommentEventService CommentEventService;
	
	
	
	
	@ApiOperation(value = "Add comment Event")
	@PostMapping("/add-event-comment")
	@ResponseBody	
	public void addEvent(@RequestBody CommentEvent commentevent) {
		CommentEventService.addEventComment(commentevent);;		

	}

	
	@GetMapping("/list-comment-events")
	@ResponseBody
	public List<CommentEvent> ListCommentEvents()
	{
		return CommentEventService.retrieveComment();
	}
	
	
	@PutMapping("/update-comment-event{idC}/{comment}")
	@ResponseBody
	@JsonIgnore
	public void updateEvent( @PathVariable Long idC,@PathVariable String comment)
	{
		CommentEventService.AlterComment(idC, comment);
	}
	
	@DeleteMapping("delete-comment-event{idC}")
	@ResponseBody
	public void DeleteEvent(@PathVariable Long idC)
	{
		CommentEventService.deleteEventComment(idC);
	}
	
	
	@PostMapping("/add-listComments/{idEvent}")
	@ResponseBody
	void AddandAssignListComments(@RequestBody List<CommentEvent> comments,@PathVariable("idEvent") long idEvent) {
	   CommentEventService.AddandAssignComment(comments, idEvent);
	}
	
}
