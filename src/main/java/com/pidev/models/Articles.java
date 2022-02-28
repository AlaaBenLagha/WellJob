package com.pidev.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name ="articles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Articles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Article")
	private Long IdArticle;
	
	@NonNull private String LabelArticle;
	
	@Enumerated(EnumType.STRING)
	private CategoryArticle CategoryArticle;
	
	@NonNull private String Subject;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy="articles")
	private Set<CommentArticle> commentArticles;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToOne
	private LikeArticle likeArticle;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_user")
	@ToString.Exclude
	private User user;

}
