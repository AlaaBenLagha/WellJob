package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Offre;

@Repository
public interface OffreRepository extends CrudRepository<Offre,Long>{

}
