package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Offre;
import com.pidev.repository.OffreRepository;
import com.pidev.serviceInterface.IOffreService;

@Service
public class OffreServiceImpl implements IOffreService{
	@Autowired
	OffreRepository offreRepository;

	@Override
	public List<Offre> getAllOffres() {
		return (List<Offre>) offreRepository.findAll();
	}

	@Override
	public Offre addOffre(Offre offre) {
		return offreRepository.save(offre);
	}

	@Override
	public void deleteOffre(Long id) {
		offreRepository.deleteById(id);
		
	}

	@Override
	public Offre updateOffre(Offre offre, Long id) {
		offre.setIdOffre(id);
		return offreRepository.save(offre);
	}

	@Override
	public Offre retrieveOffre(Long id) {
		return offreRepository.findById(id).get();
	}


	
}
