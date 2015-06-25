package com.aricent.filter;

import java.util.List;

import com.aricent.bean.FlightDetails;

public class DepartureArrivalFilter implements FliterCriteria{

	private FliterCriteria departureCriteria = null;
	private FliterCriteria arrivalCriteria = null;
	
	public DepartureArrivalFilter(FliterCriteria departureCriteria,FliterCriteria arrivalCriteria){
		this.departureCriteria = departureCriteria;
		this.arrivalCriteria = arrivalCriteria;
	}
	@Override
	public List<FlightDetails> fliterSearch(List<FlightDetails> list) {
		List<FlightDetails> listofDepartureFlights = departureCriteria.fliterSearch(list);
		return arrivalCriteria.fliterSearch(listofDepartureFlights);
	}

}
