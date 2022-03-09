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
public interface EventRepository extends JpaRepository<Event, Long> {

	// @Query(value="Select * FROM events e where e.theme_event LIKE :eventS and
	// e.date_event BETWEEN ':dateToday' and ':weeklater'",nativeQuery = true)
	@Query("Select e from Event as e  where e.themeEvent= ?1 and e.dateEvent BETWEEN ?2 and ?3")
	public Set<Event> EventInterest(Theme eventS, Date date, Date weeklater);


	@Query("select count(u) ,e.idEvent from User u join Event e where e.idEvent=?1 and e.likeEvent=?2")
	public EventParticipant getNbUsers(long ide,int maxlike);
	
	@Query("select e from Event e where e.dateEvent BETWEEN ?1 and ?2")
	public Set<Event> getEventInDate(Date date,  Date weeklater);
	
	
	@Query("select MAX(e.likeEvent) from Event e group by e.idEvent order by nb DESC ")
	public int maxlike();
	
	
	
	
	@Query("select e from Event as e where e.likeEvent=?1")
	public Event getEventByMaxLike(int nb);

	@Query("select MAX(e.likeEvent) from Event e")
	public int getmaxlike();
	
	
	
	
	@Query("select e from Event as e where  SIZE(e.users)<e.capacity ")
	public List<Event> getEventByParticipant();

	
	
	@Query("select e from User as  u,Event as e where  u.id=?1")
	public List<Event> getEventsByuser(long idUser);

	
	
	@Query("Select e from Event as e  where e.dateEvent BETWEEN ?1 and ?2")
	public Set<Event> getAlltheEventsByDate(Date date, Date weeklater);

	
	
	
	
	
	
	
	
	
	

	// @Query(value="select count(users_id_user),events_id_event from events_users "
	 //		+ "where events_id_event in (select e.id_event from events as e where e.date_event BETWEEN 'dateToday' and ':weeklater') and max(like_event) group "
	 //		+ " by events_id_event DESC LIMIT 1 ",nativeQuery = true)
	//@Query("select COUNT(u) as nb ,e.idEvent from User as  u ,Event as e where e.idEvent in (select ev.idEvent from Event ev where e.dateEvent BETWEEN ?1 and ?2)"
			//+ " and  e.likeEvent=MAX(e.likeEvent) group by e.idEvent order by nb DESC ")
	
	
	//@Query("select Count(u) ,e.idEvent from User as u join Event as e"
			//+ " where e.idEvent in (select ev.idEvent from Event ev where e.dateEvent BETWEEN ?1 and ?2)"
			//+ " and  e.likeEvent=MAX(e.likeEvent) group by e.idEvent order by nb DESC")
	//public EventParticipant getEventbyParticipant( Date date,  Date weeklater);
}
