package com.pidev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Profil;

@Repository
public interface ProfilRepository extends CrudRepository<Profil, Long> {
	
	@Query(value = "SELECT * FROM profil pf WHERE pf.score = (SELECT MAX(score) from profil)" , nativeQuery = true)
	List<Profil> retrieveProfilByMaxScore(); 
}
