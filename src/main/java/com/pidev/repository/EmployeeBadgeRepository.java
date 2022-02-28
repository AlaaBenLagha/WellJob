package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.EmployeeBadge;


@Repository
public interface EmployeeBadgeRepository extends CrudRepository<EmployeeBadge,Long> {

}
