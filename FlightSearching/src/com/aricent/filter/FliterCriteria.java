package com.aricent.filter;

import java.util.List;

import com.aricent.bean.FlightDetails;

public interface FliterCriteria {

	public List<FlightDetails> fliterSearch(List<FlightDetails> list);
}
