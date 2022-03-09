package com.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer>{

}
