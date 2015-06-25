package com.edu.hangman;
/***
 * 
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Final2 {

	private Scanner in;
	private BufferedReader bufferReader;
	private String csvFileSplitBy = ",";
	private String filePath;
	public Final2() {
		in = new Scanner(System.in);
		
	}
	public Final2(String filePath){
		this();
		this.filePath = filePath;
	}
	
	 public String getGuess()
	 {
		 return in.nextLine();
	 }
	 /***
	  * validate the input
	  * @param input : input provided by the player
	  * @return
	  */
	 public Boolean validateInput(String input){
		 for(int i = 0 ; i < input.length();i++){
			 int asciiValue = (int)input.charAt(i);
			 if(((asciiValue>=65)&&(asciiValue<=90)) || ((asciiValue>=97)&&(asciiValue<=122))){
				 continue;
			 }else{
				 return false;
			 }
		 }
		 return true;
	 }
	 /***
	  * Read the comma seperated words from the input file
	  * @return
	  */
	 public List<String> getListOfWords(){
		 List<String> listofWords = new ArrayList<String>();
		 try {
			bufferReader =  new BufferedReader(new FileReader(filePath));
			 String line;
			 try {
				while((line  = bufferReader.readLine()) != null){
					 		String[] array = line.split(csvFileSplitBy);
					 		listofWords = Arrays.asList(array);
				 }
			} catch (IOException e) {
				System.out.println("IO Exception occured while reading DATA from file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND"+filePath);
		}

		 return listofWords;
	 }
}
