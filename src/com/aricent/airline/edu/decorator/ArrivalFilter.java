package com.aricent.airline.edu.decorator;

import java.util.ArrayList;
import java.util.List;

import com.aricent.airline.edu.FlightDetails;


public class ArrivalFilter implements Filter{

	private static List<FlightDetails> listofflightarrivals= new ArrayList<FlightDetails>();
	@Override
	public List<FlightDetails> filterFlights(List<FlightDetails> listofFlightDetails,String arrivalLocation) {
		for(int i = 0; i < listofFlightDetails.size();i++){
			if(listofFlightDetails.get(i).getArrival().equalsIgnoreCase(arrivalLocation)){
				listofflightarrivals.add(listofFlightDetails.get(i));
			}
		}
		return listofflightarrivals;
	}

}
