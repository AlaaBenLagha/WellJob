package com.pidev.services;

import java.util.List;

import com.pidev.models.Badge;

public interface IBadgeService {
	
	Badge addBadge(Badge b);
	void deleteBadge(Long IdBadge);
	Badge updateBadge(Badge p);
	Badge getbyId(Long IdBadge );
	List<Badge> retriveAllBadge();
	
	void assynBadgeToProfil(Long idBadge,Long idProfil);
	
}
