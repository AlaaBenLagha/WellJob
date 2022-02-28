package com.pidev.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.models.Event;
import com.pidev.models.Theme;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
	
	
	@Query("Select e FROM events as e  where e.theme_event LIKE :eventS and e.date_event BETWEEN ':dateToday' and ':weeklater'")
	public Set<Event> EventInterest(@Param("eventS") Theme eventS,@Param("dateToday") Date date,@Param("weeklater") Date weeklater);

}
