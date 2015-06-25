package com.aricent.filter;

import java.util.ArrayList;
import java.util.List;

import com.aricent.bean.FlightDetails;

public class DepartureFilter implements FliterCriteria {

	private String departureLocation = null;
	public DepartureFilter(String departureLocation)
	{
		this.departureLocation = departureLocation;
	}
	@Override
	public List<FlightDetails> fliterSearch(List<FlightDetails> listofFlightDetails) {
		List<FlightDetails> listofflightdeparture= new ArrayList<FlightDetails>();
		for(int i = 0; i < listofFlightDetails.size();i++){
			if(listofFlightDetails.get(i).getDepature().equalsIgnoreCase(departureLocation)){
				listofflightdeparture.add(listofFlightDetails.get(i));
			}
		}
		return listofflightdeparture;
	}

}
