package com.pidev.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="attemptedQuiz")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttemptedQuiz implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private Long quizId;
	
	@JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
	
//	@OneToMany(mappedBy="attemptedQuiz",cascade=CascadeType.ALL)
//	@JsonIgnore
//
//	private Set<QuizQuestions> questions=new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public Set<QuizQuestions> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(Set<QuizQuestions> questions) {
//		this.questions = questions;
//	}

	
	
	

	
	

}
