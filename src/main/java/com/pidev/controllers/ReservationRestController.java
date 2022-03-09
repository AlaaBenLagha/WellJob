package com.pidev.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.IOException;
import com.lowagie.text.DocumentException;
import com.pidev.models.Reservation;
import com.pidev.serviceInterface.IReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
	
	@Autowired
	IReservationService reservationService;
	
			//http://localhost:8082/SpringMVC/reservation/add
			@PostMapping("/add")
			@ResponseBody	
			public Reservation addReservation(@RequestBody Reservation reservation) {
				return reservationService.addReservation(reservation);		

			}
			
			//http://localhost:8082/SpringMVC/reservation/reservationslist
			@GetMapping("/reservationslist")
			@ResponseBody
			public List<Reservation> GetReservation() {
				return reservationService.getAllReservations();

			}
			
			//http://localhost:8082/SpringMVC/reservation/getreservation/
			@GetMapping("/getreservation/{id}")
			@ResponseBody
			public Reservation GetReservation(@PathVariable("id")  Long id) {
				return reservationService.getReservation(id);

			}
			
			//http://localhost:8082/SpringMVC/reservation/deletereservation/
			@DeleteMapping("/deletereservation/{id}")
			@ResponseBody
			public void deleteCollaboration(@PathVariable("id")  Long id) {
				reservationService.deleteReservation(id);

			}
			
			//http://localhost:8082/SpringMVC/reservation/updatereservation/
			@PutMapping("/updatereservation/{id}")
			@ResponseBody
			public Reservation updateCollaboration(@RequestBody Reservation reservation, @PathVariable("id")  Long id) {
				return reservationService.updateReservation(reservation, id);

			}
			
			
			//pdf
			//http://localhost:8082/SpringMVC/reservation/export/pdf
			@GetMapping("/export/pdf")
		    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		        reservationService.generatePdf(response);
			}
	
	

}
