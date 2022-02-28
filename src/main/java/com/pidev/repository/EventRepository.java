package com.pidev.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.models.Event;
import com.pidev.models.EventParticipant;
import com.pidev.models.Theme;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
	
	
	@Query(value="Select e FROM events as e  where e.theme_event LIKE :eventS and e.date_event BETWEEN ':dateToday' and ':weeklater'",nativeQuery = true)
	public Set<Event> EventInterest(@Param("eventS") Theme eventS,@Param("dateToday") Date date,@Param("weeklater") Date weeklater);

	
	
	
	@Query(value="select count(users_id_user),events_id_event from users_events where events_id_event in (select e.id from events as e where   e.date_event BETWEEN 'dateToday' and ':weeklater') group by events_id_event DESC LIMIT 1 ",nativeQuery = true)
	public EventParticipant getEventbyParticipant(@Param("dateToday") Date date,@Param("weeklater") Date weeklater);
	
	

}
