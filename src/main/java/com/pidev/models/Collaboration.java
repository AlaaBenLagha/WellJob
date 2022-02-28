package com.pidev.models;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Collaboration implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCollaboration;
	@NonNull
	private String CollaboratedWith;
	@NonNull
	private String InfosCollaboration;
	@NonNull
	private String Advantages;
	@NonNull
	private String TypeCollaboration;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="collaboration")
	private Set<Offre> offres;

	
	@ManyToOne
	private User user;
	
	
}
