package com.pidev.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name ="postNewsFeed")
public class PostNewsFeed implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPost;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date DatePost;
	@NonNull
	private String ContentPost;
	private int LikePost;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="postNewsFeed")
	private Set<CommentNewsFeed> commentNewsFeeds;
	
	@JsonIgnore
	@ManyToOne
	@ToString.Exclude
	private User user;

}
