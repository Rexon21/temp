package com.example.Ticketnew.Entity;

import org.springframework.stereotype.Component;

@Component
public class TicketResponse {
	
	private String movieId;
	private String moviename;
	private String showTime;
	private int availableTickets;
	private String status;

	public TicketResponse() {
		super();
	}
	
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	@Override
	public String toString() {
		return "TicketResponse [movieId=" + movieId + ", moviename=" + moviename + ", showTime=" + showTime
				+ ", availableTickets=" + availableTickets + ", status=" + status + "]";
	}
	public TicketResponse(String movieId, String moviename, String showTime, int availableTickets, String status) {
		super();
		this.movieId = movieId;
		this.moviename = moviename;
		this.showTime = showTime;
		this.availableTickets = availableTickets;
		this.status = status;
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
	public int getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
