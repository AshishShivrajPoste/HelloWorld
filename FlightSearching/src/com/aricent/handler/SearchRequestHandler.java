package com.aricent.handler;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.aricent.bean.FlightDetails;
import com.aricent.filter.ArrivalFilter;
import com.aricent.filter.DepartureArrivalFilter;
import com.aricent.filter.DepartureFilter;

public class SearchRequestHandler {

		public static void main(String args[]){
			
			Set<Object> set = new HashSet<>();
			set.add("ashish");
			set.add(null);
			set.add("poste");
			set.add(1);
			Iterator<Object> ite = set.iterator();
			while(ite.hasNext()){		
				Object obj = ite.next();
				System.out.println(obj);
			}
			
			FetchInput fetchInput = new FetchInput();
			List<FlightDetails> listofFlightDetails =  fetchInput.getAllInputFiles();
			
			DepartureFilter departureFilter = new DepartureFilter("DEL");
			ArrivalFilter arrivalFilter = new ArrivalFilter("BAN");
			DepartureArrivalFilter departureArrivalFilter = new DepartureArrivalFilter(departureFilter, arrivalFilter);
			
			List<FlightDetails> listofOutput = departureArrivalFilter.fliterSearch(listofFlightDetails);
			System.out.println(listofOutput.toString());
		}
}
