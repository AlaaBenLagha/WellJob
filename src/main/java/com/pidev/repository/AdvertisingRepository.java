package com.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.models.Advertising;


@Repository
public interface AdvertisingRepository extends CrudRepository<Advertising,Long>{
	
	@Query(value="SELECT ad FROM Advertising ad WHERE ad.TitleAd= :TitleAd", nativeQuery=false)
	List<Advertising> retrieveAdvertisingByTitle(@Param("TitleAd") String titleAd);
}
