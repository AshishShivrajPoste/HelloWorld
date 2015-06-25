package com.aricent.bean;

import java.util.Date;

public class FlightDetails {

	private String flightNo = null;
	private String depature = null;
	private String arrival = null;
	private String validTill = null;
	private String fare = null;
	private String duration = null;
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	
	 @Override
	    public String toString() {
	        return String.format(flightNo+" "+depature+" "+arrival+" "+validTill+" "+fare+" "+duration+"\n");
	    }
	
}
