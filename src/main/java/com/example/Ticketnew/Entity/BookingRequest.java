package com.example.Ticketnew.Entity;

public class BookingRequest {
	
	private String userId;
	private String movieId;
	private String showTime;
	private int numberOfTickets;
	private String paymentMethod;
	
	public BookingRequest() {
		super();
	}
	@Override
	public String toString() {
		return "BookingRequest [userId=" + userId + ", movieId=" + movieId + ", showTime=" + showTime
				+ ", numberOfTickets=" + numberOfTickets + ", paymentMethod=" + paymentMethod + "]";
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
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
