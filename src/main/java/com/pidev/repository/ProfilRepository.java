package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Profil;

@Repository
public interface ProfilRepository extends CrudRepository<Profil, Long> {

}
