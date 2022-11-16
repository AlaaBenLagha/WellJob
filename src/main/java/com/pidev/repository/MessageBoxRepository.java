package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.MessageBox;

@Repository
public interface MessageBoxRepository extends CrudRepository<MessageBox, Long> {

}
