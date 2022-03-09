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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	
	@NotEmpty
	@NotBlank(message="This field is required!")
	private String CollaboratedWith;
	@Max(5)
	@Min(value=3, message="too low!")
	private String InfosCollaboration;
	@Pattern(regexp="[a-zA-Z]+", message="Incorrect form!")
	private String Advantages;
	@Pattern(regexp="[a-zA-Z]+")
	private String TypeCollaboration;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="collaboration")
	private Set<Offre> offres;

	
	
}
