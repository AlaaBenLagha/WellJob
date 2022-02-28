package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.CommentEvent;
import com.pidev.models.Event;


public interface ICommentEventService {
	public void  addEventComment ( CommentEvent commentevent);
	public void deleteEventComment (Long idC);
	public List<CommentEvent> retrieveComment();
	public void AlterComment(Long idC,String comment);
}
