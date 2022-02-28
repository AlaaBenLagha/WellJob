package com.pidev.models;

public class EventParticipantImpl implements EventParticipant {

	
	private long eventId;
	private int participant;
	
	
	@Override
	public long getEventId() {
		return eventId;
	}

	@Override
	public int getParticipant() {
		return participant;
	}

}
