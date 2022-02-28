package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Option;


@Repository
public interface OptionRepository extends CrudRepository<Option,Long> {

}
