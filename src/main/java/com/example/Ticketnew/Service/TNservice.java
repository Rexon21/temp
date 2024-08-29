package com.example.Ticketnew.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.Ticketnew.Entity.BookingRequest;
import com.example.Ticketnew.Entity.BookingResponse;
import com.example.Ticketnew.Entity.TicketResponse;
import com.example.Ticketnew.Entity.TicketsRequest;

import jakarta.mail.MessagingException;


@Service
public class TNservice {
	
	@Autowired
	RestTemplate rs;
	
	@Autowired
	private EmailService emailService;
	
	TicketResponse ticketresponse =null;

	String agsurl = "http://localhost:9090/ags";
	String pvrurl = "http://localhost:9010/pvr";
	String baseurl ="http://localhost:8080/ticketnew";
	
	public List<String> Lists(){
		
		List<String> theaters=new ArrayList<String>();
		theaters.add("AGS,T.Nagar");
		theaters.add("PVR,Vadapalani");
		
		return theaters;
		
	}
	
	public List<TicketResponse> Agsmovies(String Theater) {
		String url = null;
		switch(Theater) {
		case "ags":
			 url= agsurl+"/movielist";
			break;
		case "pvr":
		     url= pvrurl+"/movielist";
			break;
		}
		
//		String urlC=baseurl+"/Ags/Book";
		return rs.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<TicketResponse>>() {
		}).getBody();
		
		
	}
	
	public TicketResponse book(TicketsRequest tr,String Theater) {
		String url = null;
		switch(Theater) {
		case "ags":
			 url= agsurl;
			break;
		case "pvr":
		     url= pvrurl;
			break;
		}
		
		String baseurl = url+"/Ticket";
		
		  HttpEntity<TicketsRequest> requestEntity = new HttpEntity<>(tr);
		  
		  TicketResponse  response=rs.exchange(baseurl, HttpMethod.POST,requestEntity,new ParameterizedTypeReference<TicketResponse>() {
			}).getBody();
		  
		  ticketresponse=response;
		
		return response;
		
	}
	
	public ResponseEntity<byte[]> conformticket(BookingRequest BR,String Theater) throws MessagingException {
		
		String url = null;
		switch(Theater) {
		case "ags":
			 url= agsurl;
			break;
		case "pvr":
		     url= pvrurl;
			break;
		}
		
		String baseurl = url+"/Ticket/Book";
		
		if (ticketresponse == null) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (ticketresponse.getMovieId().equals(BR.getMovieId())) {
		    HttpEntity<BookingRequest> requestEntity = new HttpEntity<>(BR);
		    ResponseEntity<byte[]> response = rs.exchange(baseurl, HttpMethod.POST, requestEntity, byte[].class);

		    if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
		        // Save the byte[] response as a temporary PDF file
		        File pdfFile = new File("Booking_Response.pdf");
		        try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
		            fos.write(response.getBody());
		        } catch (IOException e) {
		            e.printStackTrace();
		            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		        // Send the email with the PDF attachment
		        emailService.sendEmailWithAttachment(
		            BR.getUserId(), 
		            "Your Booking Response", 
		            "Please find the booking details attached.", 
		            pdfFile
		        );

		        // Clean up: delete the temporary file after sending the email
		        pdfFile.delete();

		        // Return the response as a downloadable PDF
		        return ResponseEntity.ok()
		                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=booking_response.pdf")
		                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
		                .body(response.getBody());
		    } else {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
		} else {
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	
}
