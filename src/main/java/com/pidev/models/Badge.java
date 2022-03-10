package com.pidev.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
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
@Entity
@ToString
@Table(name ="badge")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Badge implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Badge")
	private Long IdBadge;
	
	@NonNull 
	private String NameBadge;
	private Long  NbVote;
	@NonNull private String Category;
	@NonNull private String Description;
	@NonNull private Long Points;
	private Long CreatedBy;
	private Boolean Achieved;

	
	

}
