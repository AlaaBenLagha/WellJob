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
@Table(name ="likeNewsFeed")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikeNewsFeed implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdLike;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date DateLike;
	
	@ManyToOne
	private PostNewsFeed postNewsFeed;
	
	//Relation avec User
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	
}
