package com.aricent.airline.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AirlineSearchEngine {

	private static List<FlightDetails> listofFlightDetails = new ArrayList<FlightDetails>();
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static final String FILE_DIR = "F://TestWorkSpace//FlightDetails";
	private static final String FILE_TEXT_EXT = ".csv";
	private void getData(String csvFile){
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		FlightDetails flightDetails = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] flightdata = line.split(cvsSplitBy);
				flightDetails = new FlightDetails();
				flightDetails.setFlightNo(flightdata[0]);
				flightDetails.setDepature(flightdata[1]);
				flightDetails.setArrival(flightdata[2]);
				flightDetails.setValidTill(flightdata[3]);
				flightDetails.setFare(flightdata[4]);
				flightDetails.setDuration(flightdata[5]);
				listofFlightDetails.add(flightDetails);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public List<FlightDetails> getflightdeparting(List<FlightDetails> listofFlightDetails,String departureLocation){	
		List<FlightDetails> listofflightdeparture= new ArrayList<FlightDetails>();
		for(int i = 0; i < listofFlightDetails.size();i++){
			if(listofFlightDetails.get(i).getDepature().equalsIgnoreCase(departureLocation)){
				listofflightdeparture.add(listofFlightDetails.get(i));
			}
		}
		return listofflightdeparture;
	}
	public List<FlightDetails> getflightArriving(List<FlightDetails> listofflightdeparture,String arrivalLocation){	
		List<FlightDetails> listofflightarrivals= new ArrayList<FlightDetails>();
		for(int i = 0; i < listofflightdeparture.size();i++){
			if(listofflightdeparture.get(i).getArrival().equalsIgnoreCase(arrivalLocation)){
				listofflightarrivals.add(listofflightdeparture.get(i));
			}
		}
		return listofflightarrivals;
	}
	
	public List<FlightDetails> getflightValidDate(List<FlightDetails> listofflightarrivals,String validDate) throws ParseException{	
		List<FlightDetails> listofflightValidTill = new ArrayList<FlightDetails>();
		Date date1 = formatter.parse(validDate);
		for(int i = 0; i < listofflightarrivals.size();i++){
			Date date2 = formatter.parse(listofflightarrivals.get(i).getValidTill());
			if(date2.compareTo(date1)<=0){
				listofflightValidTill.add(listofflightarrivals.get(i));
			}
		}
		return listofflightValidTill;
	}
	public List<FlightDetails> getflightFareWise(List<FlightDetails> listofflightValidTill,String fareConstaint){	
		List<FlightDetails> listofflightFareWise = new ArrayList<FlightDetails>();
		for(int i = 0; i < listofflightValidTill.size();i++){
			if(Integer.parseInt((listofflightValidTill.get(i).getFare())) <= Integer.parseInt(fareConstaint)){
				listofflightFareWise.add(listofflightValidTill.get(i));
			}
		}
		return listofflightFareWise;
	}
	public void printOutput(List<FlightDetails> list){
		for(int i = 0; i<list.size();i++){
			System.out.print(" "+list.get(i).getFlightNo());
			System.out.print(" "+list.get(i).getDepature());
			System.out.print(" "+list.get(i).getArrival());
			System.out.print(" "+list.get(i).getValidTill());
			System.out.print(" "+list.get(i).getFare());
			System.out.print(" "+list.get(i).getDuration());
			System.out.println();
		}
		
	}
	public void getAllInputFiles(){
		File dir = new File(FILE_DIR);
		if(dir.isDirectory()==false){
			System.out.println("Directory does not exists : " + FILE_DIR);
			return;
		}
		String[] list = dir.list();
		if (list.length == 0) {
			System.out.println("no files end with : " + FILE_TEXT_EXT);
			return;
		}
		for (String file : list) {
			String csvFile = new StringBuffer(FILE_DIR).append(File.separator).append(file).toString();
			getData(csvFile);
		}
	}
	public static void main(String args[]){
		AirlineSearchEngine searchEngine = new AirlineSearchEngine();
		searchEngine.getAllInputFiles();
		try {
			List<FlightDetails> output = searchEngine.getflightFareWise(searchEngine.getflightValidDate(searchEngine.getflightArriving(searchEngine.getflightdeparting(listofFlightDetails, args[0]), args[1]), args[2]), args[3]);
			searchEngine.printOutput(output);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
