package com.pidev.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.pidev.models.Reservation;

public interface IReservationService {
	List<Reservation> getAllReservations();
	Reservation addReservation(Reservation reservation);
	void deleteReservation(Long id);
	Reservation updateReservation(Reservation reservation , Long id);
	Reservation getReservation(Long id);
	void generatePdf(HttpServletResponse response);
}
