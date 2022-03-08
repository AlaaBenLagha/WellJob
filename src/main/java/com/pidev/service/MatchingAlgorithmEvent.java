package com.pidev.service;

import java.util.Date;
import java.util.Set;

import com.pidev.models.Event;
import com.pidev.models.Location;
import com.pidev.models.User;

public interface MatchingAlgorithmEvent {
	
	
	public boolean MaxLike(Event event);
	public boolean ThemeCheck(Event event,User user);
	public boolean locationCheck(Location locationEvent,Location locationUser);
	public boolean capacityCheck(Event event);
	public Date addDays(Date date ,int days);
	public Set<Event> getAlltheEvent(long idUser);
	

}
