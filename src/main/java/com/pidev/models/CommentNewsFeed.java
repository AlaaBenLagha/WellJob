package com.pidev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="commentNewsFeed")
public class CommentNewsFeed implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdComment;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date DateComment;
	@NonNull
	private String ContentComment;
	
	@ManyToOne
	private PostNewsFeed postNewsFeed;
	
	//Relation avec User
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	

	
	

}
