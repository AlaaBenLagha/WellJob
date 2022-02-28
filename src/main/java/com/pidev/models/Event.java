package com.pidev.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="events")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdEvent; 
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date DateEvent ;
	@NonNull
	private String NameEvent ;
	private String Program;
	private String Infos;
	private Long Capacity ; 
	private int LikeEvent;
	@Enumerated(EnumType.STRING)
	public Theme ThemeEvent;  
	//@JsonIgnore
	@ManyToMany(mappedBy="events", cascade = CascadeType.ALL )
	private Set<User> users;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	private Set<CommentEvent> commentEvents;
	


}
