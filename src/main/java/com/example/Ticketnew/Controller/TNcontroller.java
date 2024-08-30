package com.example.Ticketnew.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ticketnew.Service.TNservice;

import jakarta.mail.MessagingException;

import com.example.Ticketnew.Entity.*;



@RestController
@RequestMapping("/showMovies")
public class TNcontroller {
	
	@Autowired
	TNservice Ts;
	@GetMapping("/theatres")
	List<String> theaterList(){
		
	return Ts.Lists();
		
	}
	
	@GetMapping("/theaters/{Theater}")
	Iterable<TicketResponse> AgsMovies(@PathVariable  String Theater){

		return Ts.Agsmovies(Theater);
				
	}
	
	@PostMapping("/theaters/{Theater}/ticket")
	TicketResponse Movies(@RequestBody TicketsRequest TR,@PathVariable  String Theater){

		return Ts.book(TR,Theater);
				
	}
	
	@PostMapping("/theaters/{Theater}/ticket/confirm")
	ResponseEntity<byte[]> confirm(@RequestBody BookingRequest BR,@PathVariable  String Theater) throws MessagingException {
		return Ts.conformticket(BR, Theater);
		
	}
	
	
	
	
	
	
	
	
	
	

}
