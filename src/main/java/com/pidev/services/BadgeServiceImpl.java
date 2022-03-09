package com.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Badge;
import com.pidev.models.Profil;
import com.pidev.repositories.BadgeRepository;
import com.pidev.repositories.ProfilRepository;


@Service
public class BadgeServiceImpl implements IBadgeService{

	@Autowired
	BadgeRepository badgerepository;
	
	@Autowired
	ProfilRepository profilRepository;
	
	@Override
	public Badge addBadge(Badge b) {
		return badgerepository.save(b);
	}

	@Override
	public void deleteBadge(Long IdBadge) {
		// TODO Auto-generated method stub
		badgerepository.deleteById(IdBadge);
	}

	@Override
	public Badge updateBadge(Badge b) {
		// TODO Auto-generated method stub
		//Badge b = badgerepository.findById(IdBadge).orElse(null);
		
		return badgerepository.save(b);
	}

	@Override
	public Badge getbyId(Long IdBadge) {
		// TODO Auto-generated method stub
		Badge b = badgerepository.findById(IdBadge).orElse(null);
		return b;
	}

	@Override
	public List<Badge> retriveAllBadge() {
		// TODO Auto-generated method stub
		return (List<Badge>)badgerepository.findAll();
	}

	@Override
	public void assynBadgeToProfil(Long idBadge, Long idProfil) {
		// TODO Auto-generated method stub
		Badge ba = badgerepository.findById(idBadge).orElse(null);
		
		Profil pf = profilRepository.findById(idProfil).orElse(null);
		ba.setProfil(pf);
		
		badgerepository.save(ba);
		
	}

}
