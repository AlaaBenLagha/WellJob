package com.pidev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="reservations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdReservation;
	@NonNull
	private String CompanyName;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date DateReservation;
	@NonNull
	private String TypeCompany;
	@NonNull
	private Long Duration;
	@NonNull
	private String ReservedBy;
	@NonNull
	private Long Tel;
	@NonNull
	private Long NumberPeople;
	
	//Relation avec User
	@ManyToOne
	private User user;
	
	
	
	
	
}
