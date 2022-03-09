package com.pidev.serviceInterface;

import java.util.Date;
import java.util.List;
import java.util.Set;
import com.pidev.models.Event;
import com.pidev.models.Location;
import com.pidev.models.User;




public interface IEventService {
	public void  addEvent( Event event);
	public void deleteEvent (long idE);
	public List<Event> retrieveEvents();
	public void AlterEvent(Long idE,Long capacity, String infos,String name,String prog);
	public void AssignUsertoEvent(long idUser,long idEvent);
	public Event getTrendingEvent();
	public void AssignloctoEvent(int idLocation, long idEvent);
	
}
