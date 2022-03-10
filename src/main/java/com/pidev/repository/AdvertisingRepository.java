package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Advertising;

@Repository
public interface AdvertisingRepository extends CrudRepository<Advertising,Long>{

}
