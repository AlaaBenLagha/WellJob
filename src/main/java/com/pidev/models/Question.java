package com.pidev.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@ToString
@Table(name ="questions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="Id_Question")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdQuestion;
	
	@Column(name="Content_Question")
	@NonNull 
	private String ContentQuestion;
	
	@ManyToOne
	private Quiz quiz;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
	private Set<Option> options;
	

}
