package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.ReviewEmployee;



@Repository
public interface ReviewEmployeeRepository  extends CrudRepository<ReviewEmployee,Long> {

}
