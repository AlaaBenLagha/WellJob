package com.pidev.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.io.IOException;
import com.lowagie.text.DocumentException;
import com.pidev.config.PdfGenerator;
import com.pidev.models.Reservation;
import com.pidev.repository.ReservationRepository;
import com.pidev.serviceInterface.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
		
	}

	@Override
	public Reservation updateReservation(Reservation reservation, Long id) {
		reservation.setIdReservation(id);
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservation(Long id) {
		return reservationRepository.findById(id).get();
	}

	@Override
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Reservation> listReservations = (List<Reservation>) reservationRepository.findAll();
         
        PdfGenerator generator = new PdfGenerator(listReservations);
        try {
			generator.export(response);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

		
	}


