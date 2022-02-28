package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.ReservationRepository;
import com.pidev.serviceInterface.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	ReservationRepository reservationRepository;

}
