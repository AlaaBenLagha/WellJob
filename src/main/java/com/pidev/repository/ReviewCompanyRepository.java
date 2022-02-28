package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.ReviewCompany;



@Repository
public interface ReviewCompanyRepository extends CrudRepository<ReviewCompany,Long> {

}
