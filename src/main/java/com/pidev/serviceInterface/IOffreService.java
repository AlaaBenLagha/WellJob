package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.Offre;

public interface IOffreService {
	List<Offre> getAllOffres();
	Offre addOffre(Offre Article);
	void deleteOffre(Long id);
	Offre updateOffre(Offre Article , Long id);
	Offre retrieveOffre(Long id);

}
