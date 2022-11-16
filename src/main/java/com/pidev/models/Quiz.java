package com.pidev.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name ="quizs")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long qid;
	
	private String title;
	
	private String description;
	
	private String numberOfQuestions;
	
	private String maxMarks;
	
	 private int Views;
	    
	 private int keywords_number;

	 
	 
	 

	
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Question> question=new HashSet<>();
	
	@JsonIgnore
	@ManyToOne
	@ToString.Exclude
	private User user;

	
	
	
	
	
	
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	
	public Quiz(Long qid, String title, String description, String numberOfQuestions, String maxMarks, boolean active,
			Category category, Set<Question> question) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
		this.maxMarks = maxMarks;
		this.active = active;
		this.category = category;
		this.question = question;
	}
	
	public int getViews() {
		return Views;
	}

	public void setViews(int Views) {
		this.Views = Views;
	}

	public int getKeywords_number() {
		return keywords_number;
	}

	public void setKeywords_number(int keywords_number) {
		this.keywords_number = keywords_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}
	
	


	

	
	

}
