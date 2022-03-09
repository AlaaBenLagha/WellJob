package com.pidev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name ="offres")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offre implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdOffre;
	@NonNull
	private String ContentOffre;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date EndDate;
	
	@OneToOne
	private Advertising advertising;
	
	@ManyToOne
	private Collaboration collaboration;
	
	@ManyToOne
	private User user;

}
