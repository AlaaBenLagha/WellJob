package com.pidev.service;


import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.CommentEvent;
import com.pidev.models.Event;
import com.pidev.models.EventParticipant;
import com.pidev.models.Location;
import com.pidev.models.Theme;
import com.pidev.models.User;
import com.pidev.repository.CommentEventRepository;
import com.pidev.repository.EventRepository;
import com.pidev.repository.LocationRepository;
import com.pidev.repository.UserRepository;
import com.pidev.serviceInterface.IEventService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventServiceImpl  implements IEventService{
	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRep;
	@Autowired
	CommentEventRepository commentRep;
	@Autowired
	LocationRepository locationRep;
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
	public void deleteEvent(long idE) {
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
	public void AssignUsertoEvent(long idUser, long idEvent) {
		User user=userRep.findById(idUser).orElse(null);
		Event event=eventRepository.findById(idEvent).orElse(null);
		log.info("user: "+user.getUserName());
		log.info("event: "+event.getNameEvent());
		event.getUsers().add(user);
		eventRepository.save(event);
	}

	public Date addDays(Date date ,int days){
		Calendar cal= Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return cal.getTime();
		
	}

		public Event getTrendingEvent() {
	
			Date date= new Date() ;
			Date date2= this.addDays(date, 7);
		
			Set<Event> events =eventRepository.getEventInDate(date, date2);
			Event maxLikesEvent = null ;
			
			for (Event e : events)
			{
				if (e.getCapacity() == e.getUsers().size())
					continue ;
				
				if (maxLikesEvent == null)
					maxLikesEvent = e  ;
				else if (e.getLikeEvent()>maxLikesEvent.getLikeEvent())
					maxLikesEvent = e ;
					
			}
			System.out.println("test"+maxLikesEvent);
			return maxLikesEvent ;
			
			

		}


		@Override
		public void AssignloctoEvent(int idLocation, long idEvent) {
			Location location=locationRep.findById(idLocation).orElse(null);
			Event event=eventRepository.findById(idEvent).orElse(null);
			event.setLocation(location);
			eventRepository.save(event);
		}

		
		
		
		
		
		
		
		
		
		
		
		

	/*@Override
	public Set<Event> findInterestEvent(long idu) {
		User u=userRep.findById(idu).orElse(null);
		Theme thems = u.getInterests();
		
		Date date= new Date() ;
		
		Date date2= this.addDays(date, 7);
			
			Set<Event> events =eventRepository.EventInterest(thems,date,date2) ;
			for (Event ev:events){
				log.info(ev.toString());

				if(ev.getCapacity()>ev.getUsers().size()){
					log.info(ev.toString());
					eventsFinal.add(ev);
				}
			}
		
		return eventsFinal;
	}
	*/
	
	

}
