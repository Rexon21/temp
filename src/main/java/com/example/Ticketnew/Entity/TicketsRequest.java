package com.example.Ticketnew.Entity;

public class TicketsRequest {
	
	private String movieId;
	private String showTime;
	private int numberOfTickets;
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
	@Override
	public String toString() {
		return "TicketsRequest [movieId=" + movieId + ", showTime=" + showTime + ", numberOfTickets=" + numberOfTickets
				+ "]";
	}
	public TicketsRequest(String movieId, String showTime, int numberOfTickets) {
		super();
		this.movieId = movieId;
		this.showTime = showTime;
		this.numberOfTickets = numberOfTickets;
	}
	public TicketsRequest() {
		super();
	}

}
