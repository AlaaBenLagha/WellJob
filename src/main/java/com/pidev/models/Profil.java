package com.pidev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="profils")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profil implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdProfil;
	private String Libelle;
	private String FirstName;
	private String LastName;
	private Long Age;
	private String Sexe;
	private String Departement;
	
	@Temporal(TemporalType.DATE)
	private Date BirthDate;
	
	
	
	@OneToOne
	private User user;
}
