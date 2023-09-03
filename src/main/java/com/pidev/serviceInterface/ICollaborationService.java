package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.Collaboration;


public interface ICollaborationService {
	List<Collaboration> GetAllCollaborations();
	void addCollaboration(Collaboration collaboration);
	void deleteCollaboration(Long id);
	Collaboration updateCollaboration(Collaboration collaboration , Long id);
	Collaboration getCollaboration(Long id);
//	 List<Collaboration> statistic();
//	List<Collaboration> GetAllCollaborations(Specification<Collaboration> spec);
	List<Collaboration> retrieveAdvertisingByEntreprise(String collaboratedWith);

}
