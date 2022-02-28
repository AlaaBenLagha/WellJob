package com.pidev.service;


import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Event;
import com.pidev.models.Theme;
import com.pidev.models.User;
import com.pidev.repository.EventRepository;
import com.pidev.serviceInterface.IEventService;

@Service
public class EventServiceImpl  implements IEventService{
	@Autowired
	EventRepository eventRepository;
	Set<Event> eventsFinal;
	public EventServiceImpl(Set<Event> events) {
		// TODO Auto-generated constructor stub
		this.eventsFinal=events;
	}

	@Override
	public void addEvent(Event event) {
	 eventRepository.save(event);
	}

	@Override
	public void deleteEvent(Long idE) {
		if(eventRepository.findById(idE).isPresent())
		{
			Event e=eventRepository.findById(idE).get();
			eventRepository.delete(e);
		}
		
	}

	@Override
	public List<Event> retrieveEvents() {
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public void AlterEvent(Long idE,Long capacity /*, Date dateE*/
			,String infos,String name,String prog) {
		//Event event=eventRepository.findById(idE).orElse(null);
	if(eventRepository.findById(idE).isPresent())
	{
		Event e=eventRepository.findById(idE).get();
		e.setCapacity(capacity);
		//e.setDateEvent(dateE);
		e.setInfos(infos);
		e.setNameEvent(name);
		e.setProgram(prog);
	    eventRepository.save(e);  
	}
	
	}

	@Override
	public Set<Event> findInterestEvent(User u) {
		Theme thems = u.getInterests();
		
		
		
		Date date= new Date() ;
		
		Date date2= this.addDays(date, 7);
		
		
		
		
			
			Set<Event> events =eventRepository.EventInterest(thems,date,date2) ;
			for (Event ev:events){
				if(ev.getCapacity()>ev.getUsers().size()){
					eventsFinal.add(ev);
				}
			}
		
		return eventsFinal;
	}
	
	
	public Date addDays(Date date ,int days){
		Calendar cal= Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return cal.getTime();
		
	}


}
