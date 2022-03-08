package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.CommentEvent;
import com.pidev.models.Event;
import com.pidev.repository.CommentEventRepository;
import com.pidev.repository.EventRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.ICommentEventService;

@Service
public class CommentEventServiceImpl implements ICommentEventService {
	@Autowired
	CommentEventRepository commentEventRepository;
	@Autowired
	EventRepository eventRepository;



	@Override
	public void addEventComment(CommentEvent commentevent) {
		commentEventRepository.save(commentevent);
		
	} 
	

	@Override
	public void AlterComment(Long idE, String comment) {
		if(commentEventRepository.findById(idE).isPresent())
		{
			CommentEvent c=commentEventRepository.findById(idE).get();
			c.setCommentContent(comment);
			commentEventRepository.save(c);
		}

	}

	@Override
	public void deleteEventComment(Long idC) {
		if(commentEventRepository.findById(idC).isPresent())
		{
			CommentEvent c=commentEventRepository.findById(idC).get();
			commentEventRepository.delete(c);
		}
		
	}

	@Override
	public List<CommentEvent> retrieveComment() {
		return (List<CommentEvent>) commentEventRepository.findAll();
	}

	@Override
	public void AddandAssignComment(List<CommentEvent> comments, long idEvent) {
		commentEventRepository.saveAll(comments);
	Event event=eventRepository.findById(idEvent).orElse(null);
	for(CommentEvent comment: comments)
	{
		comment.setEvent(event);
	}
	commentEventRepository.saveAll(comments);
	}

}
