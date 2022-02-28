package com.pidev.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name ="quizs")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdQuiz;
	
	@NonNull 
	private String QuizName;
	
	@Enumerated(EnumType.STRING)
	private QuizCategory Category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
	private Set<Question> questions;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
	private Set<FeedBack> feedbacks;

}
