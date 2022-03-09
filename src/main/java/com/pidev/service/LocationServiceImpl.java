package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Event;
import com.pidev.models.Location;
import com.pidev.repository.EventRepository;
import com.pidev.repository.LocationRepository;
import com.pidev.serviceInterface.IlocationService;
@Service
public class LocationServiceImpl implements IlocationService {

	@Autowired
	LocationRepository locationRep;
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public void AddLocation(Location location) {
		locationRep.save(location);
	}

	



}
