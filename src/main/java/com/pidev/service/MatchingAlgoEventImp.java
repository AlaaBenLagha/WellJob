package com.pidev.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Event;
import com.pidev.models.Location;
import com.pidev.models.Theme;
import com.pidev.models.User;
import com.pidev.repository.EventRepository;
import com.pidev.repository.UserRepository;
@Service
public class MatchingAlgoEventImp implements MatchingAlgorithmEvent {

	public static int MAXPARTICIPANTSCORE = 20;
	public static int MAXLIKESCORE = 30;
	public static int THEMESCORE = 50;
	public static int CAPACITYSCORE = 45;
	public static int LOCATIONSCORE = 60;

	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;

	 TreeMap<Integer, Event> eventTreeMap;

	 Set<Event> eventR;


	@Override
	public boolean MaxLike(Event event) {
		// TODO Auto-generated method stub
		return event.equals(eventRepository.getEventByMaxLike());
	}

	@Override
	public boolean ThemeCheck(Event event, User user) {
		// TODO Auto-generated method stub
		for (String theme : user.getInterests()) {
			if (theme.equals(event.themeEvent)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean locationCheck(Location locationEvent, Location locationUser) {
		// TODO Auto-generated method stub

		return locationEvent.equals(locationUser);
	}

	@Override
	public boolean capacityCheck(Event event) {
		// TODO Auto-generated method stub

		return event.getCapacity() > event.getUsers().size();
	}

	@Override
	public Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();

	}

	@Override
	public Set<Event> getAlltheEvent(long idUser) {
			Set<Event>eventR=new HashSet<Event>();
			eventTreeMap=new TreeMap<Integer, Event>() ;
		User user = userRepository.findById(idUser).orElse(null);
		Set<Event> events = eventRepository.getAlltheEventsByDate(new Date(), addDays(new Date(), 7));
		
		
		for (Event event : events) {

			if (capacityCheck(event)) {

				int score = 0;

				if (ThemeCheck(event, user)) {
					score += THEMESCORE;
				}
				if (locationCheck(event.getLocation(), user.getLocation())) {
					score += LOCATIONSCORE;
				}
				if (MaxLike(event)) {
					score += MAXLIKESCORE;
				}
				

				eventTreeMap.put(score, event);

			}

			for (Event eventF : eventTreeMap.descendingMap().values()) {

				eventR.add(eventF);

			}

		}

		return eventR;
	}

}
