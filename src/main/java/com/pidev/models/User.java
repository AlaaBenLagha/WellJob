package com.pidev.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_User")
	private Long IdUser;
	private String UserName;
	private String Password;
	@Enumerated(EnumType.STRING)
	private UserRole Role;
	private Long Score;
	@Enumerated(EnumType.STRING)
	private UserRank Rank;
	private String Favoris;
	private String Departement;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Reservation> reservations;
	
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Articles> articles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<PostNewsFeed> postNewsFeed;
	

	
	
}
