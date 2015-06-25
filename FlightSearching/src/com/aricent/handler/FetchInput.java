package com.aricent.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aricent.bean.FlightDetails;


public class FetchInput {

	private static final String FILE_DIR = "F://TestWorkSpace//FlightDetails";
	private static final String FILE_TEXT_EXT = ".csv";
	private static List<FlightDetails> listofFlightDetails = new ArrayList<FlightDetails>();
	public List<FlightDetails> getAllInputFiles(){
		File dir = new File(FILE_DIR);
		if(dir.isDirectory()==false){
			System.out.println("Directory does not exists : " + FILE_DIR);
			return null;
		}
		String[] list = dir.list();
		if (list.length == 0) {
			System.out.println("no files end with : " + FILE_TEXT_EXT);
			return null;
		}
		for (String file : list) {
			String csvFile = new StringBuffer(FILE_DIR).append(File.separator).append(file).toString();
			getData(csvFile);
		}
		return listofFlightDetails;
	}
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
}
