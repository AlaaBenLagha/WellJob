package com.pidev.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private String state;
	private String city;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "location")
	private Set<User> users;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST ,mappedBy = "location")
	private Set<Event> events;
	
	
	
	@Override
	public boolean equals(Object obj) {

	Location loc=(Location) obj;
	if(!loc.getCountry().equals(this.getCountry())) {
		return false;
	}
	if(!loc.getState().equals(this.getState())) {
		return false;
	}
	if(!loc.getCity().equals(this.getCity())) {
		return false;
	}
	return true;
	
	
}
}
