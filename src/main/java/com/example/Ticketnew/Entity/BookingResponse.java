package com.example.Ticketnew.Entity;

import org.springframework.stereotype.Component;

@Component
public class BookingResponse {
	
	private String bookingId;
	private String userId;
	private String movieId;
	private String showTime;
	private int numberOfTickets;
	private String status;
	private double totalAmount;
	private String currency;
	
	@Override
	public String toString() {
		return "BookingResponse [bookingId=" + bookingId + ", userId=" + userId + ", movieId=" + movieId + ", showTime="
				+ showTime + ", numberOfTickets=" + numberOfTickets + ", status=" + status + ", totalAmount="
				+ totalAmount + ", currency=" + currency + "]";
	}
	public BookingResponse() {
		super();
	}
	public BookingResponse(String bookingId, String userId, String movieId, String showTime, int numberOfTickets,
			String status, double totalAmount, String currency) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.movieId = movieId;
		this.showTime = showTime;
		this.numberOfTickets = numberOfTickets;
		this.status = status;
		this.totalAmount = totalAmount;
		this.currency = currency;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
