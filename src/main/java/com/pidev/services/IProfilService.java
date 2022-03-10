package com.pidev.services;

import java.util.List;

import com.pidev.models.Profil;

public interface IProfilService {

	public List<Profil> retrieveAllProfils();
	
	public Profil addProfil(Profil p);
	
	public List<Profil>  MaxScoreProfil();
	
	public List<Profil>  SearchProfil();
	
}
