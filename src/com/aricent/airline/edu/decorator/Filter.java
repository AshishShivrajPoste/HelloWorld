package com.aricent.airline.edu.decorator;

import java.util.List;

import com.aricent.airline.edu.FlightDetails;


public interface Filter {

	public List<FlightDetails> filterFlights(List<FlightDetails> list ,String string);
}
