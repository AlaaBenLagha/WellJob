package com.pidev.models;

public class EventParticipantImpl implements EventParticipant {

	
	private long eventId;
	private long participant;
	
	
	@Override
	public long getEventId() {
		return eventId;
	}

	@Override
	public long getParticipant() {
		return participant;
	}

}
