package com.pidev.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity

public class Badge implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBadge")
	private Long idBadge;
	
	
	private String nameBadge;
	private Long  nbVote;
	private String category;
	 
	private String description;
	private String createdBy;
	private Long  vote;
	
	@ManyToOne
	private Profil profil;
	
	public Long getIdBadge() {
		return idBadge;
	}
	public void setIdBadge(Long idBadge) {
		this.idBadge = idBadge;
	}
	public String getNameBadge() {
		return nameBadge;
	}
	public void setNameBadge(String nameBadge) {
		this.nameBadge = nameBadge;
	}
	public Long getNbVote() {
		return nbVote;
	}
	public void setNbVote(Long nbVote) {
		this.nbVote = nbVote;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Long getVote() {
		return vote;
	}
	public void setVote(Long vote) {
		this.vote = vote;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	

	

}
