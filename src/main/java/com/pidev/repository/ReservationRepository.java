package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Reservation;

@Repository
public interface ReservationRepository  extends CrudRepository<Reservation,Long>{

}
