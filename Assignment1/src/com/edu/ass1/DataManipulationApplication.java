package com.edu.ass1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * It is the main Application class containing the main method.it will drive the whole Application
 * @author 
 *
 */
public class DataManipulationApplication {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Please provide size for List");
			return;
		}
		String input = args[0];
		int size = Integer.parseInt(input);
		DataManipulator dataManipulator = new DataManipulator(size);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String ans = null;
		System.out.println("===================================================================================");
		System.out.println("========================  DATA MANIPULATION APPLICATION  ==========================");
		System.out.println("===================================================================================");
		do{
			System.out.println("Press 1 to ADD a Record");
			System.out.println("Press 2 to REMOVE/DELETE a Record");
			System.out.println("Press 3 to SEARCH a Record");
			System.out.println("Press 4 to DISPLAY all Record");
			System.out.println("Press 5 to SORT by PersonID");
			System.out.println("Press 6 to SORT by FirstName");
			System.out.println("Press 7 to SORT by LastName");
			System.out.println("Enter your choice");
			String choice = null;
			try {
				choice = bufferReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch(choice){
				case "1": 
					dataManipulator.addRecord();
					break;
				case "2":
					int personId = DataUtility.getPersonIdfromUser();
					dataManipulator.removeRecord(personId);
					break;
				case "3":
					int searchId = DataUtility.getPersonIdfromUser();
					Person person = dataManipulator.SearchRecord(searchId);
					System.out.println("Person Details : "+person);
					break;
				case "4":
					dataManipulator.displayRecords();
					break;
				case "5":
					dataManipulator.sortbyPersonId();
					break;
				case "6":
					dataManipulator.sortbyFirstName();
					break;
				case "7":
					dataManipulator.sortbyLastName();
					break;
				default:
					System.out.println("Wrong choice entered..Try again");
				
			}
			System.out.println("Do you want to continue y/n");
			try {
				ans = bufferReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(ans.equalsIgnoreCase("y"));
		
	}
}
