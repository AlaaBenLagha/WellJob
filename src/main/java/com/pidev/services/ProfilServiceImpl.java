package com.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Profil;
import com.pidev.repositories.ProfilRepository;

@Service
public class ProfilServiceImpl implements IProfilService{

	@Autowired
	ProfilRepository profilRepository;
	
	@Override
	public List<Profil> retrieveAllProfils() {
		// TODO Auto-generated method stub
		return (List<Profil>)profilRepository.findAll();
	}

	@Override
	public Profil addProfil(Profil p) {
		Profil pf = profilRepository.save(p);
		return pf;
	}

	@Override
	public List<Profil> MaxScoreProfil() {
		return (List<Profil>)profilRepository.retrieveProfilByMaxScore();
	}

	@Override
	public List<Profil> SearchProfil() {
		return (List<Profil>)profilRepository.SearchProfil();
	}

}
