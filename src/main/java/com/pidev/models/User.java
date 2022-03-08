package com.pidev.models;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name ="users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_User")
	private long IdUser;
	private String UserName;
	private String Password;
	@Enumerated(EnumType.STRING)
	private UserRole Role;
	private Long Score;
	@Enumerated(EnumType.STRING)
	private UserRank Rank;
	private String Favoris;
	private String Departement;
	@ElementCollection
	private List<String> interests; 
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Reservation> reservations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Collaboration> collaborations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Offre> offres;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<ReviewCompany> companyReviews;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Quiz> quizs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<ConversationPart> conversationParts;
	
	@OneToOne
	private Profil profil;
	
	@OneToOne
	private MessageBox messageBox;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Event> events;
	
	
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Articles> articles;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Location location;

	
	
}
