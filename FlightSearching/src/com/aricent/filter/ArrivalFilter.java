package com.aricent.filter;

import java.util.ArrayList;
import java.util.List;

import com.aricent.bean.FlightDetails;

public class ArrivalFilter implements FliterCriteria {

	private String arrivalLocation = null;
	public ArrivalFilter(String arrivalLocation){
		this.arrivalLocation = arrivalLocation;
	}
	@Override
	public List<FlightDetails> fliterSearch(List<FlightDetails> listofflightdeparture) {
		List<FlightDetails> listofflightarrivals= new ArrayList<FlightDetails>();
		for(int i = 0; i < listofflightdeparture.size();i++){
			if(listofflightdeparture.get(i).getArrival().equalsIgnoreCase(arrivalLocation)){
				listofflightarrivals.add(listofflightdeparture.get(i));
			}
		}
		return listofflightarrivals;
	}

}
