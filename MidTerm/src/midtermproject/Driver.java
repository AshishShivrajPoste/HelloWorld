/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midtermproject;
import java.io.*;
import java.util.*;

/**
 *
 * 
 */
public class Driver {
	public String ArtistName;  
	public String AlblumName;                    // Protected only by subclass 
	private static List<Album> listofAlbumSortByAlbumName = new ArrayList<Album>();
	private static List<Album> listofAlbumSortByArtistName = new ArrayList<Album>();
	public Driver()
	{
	}

	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		Driver myDriver = new Driver();
		myDriver.checkFile();
//		System.out.println("======================Album List sorted by AlbumName=================================");
//		myDriver.sortByAlbumName(listofAlbumSortByAlbumName);
//		myDriver.print(listofAlbumSortByAlbumName);
//		System.out.println("=======================Album List sorted by ArtistName================================");
//		myDriver.sortByArtistName(listofAlbumSortByArtistName);
//		myDriver.print(listofAlbumSortByArtistName);
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String ans = null;
		do{
			System.out.println("Press 1 to Sort List of Album by Album Name");
			System.out.println("Press 2 to Sort List of Album by Album Artist");
			System.out.println("Please Enter the choice");
			int choice = 0;
			choice =Integer.parseInt(scanner.nextLine());
			switch(choice){
				case 1: 
					System.out.println("======================Album List sorted by AlbumName=================================");
					myDriver.sortByAlbumName(listofAlbumSortByAlbumName);
					myDriver.print(listofAlbumSortByAlbumName);
					break;
				case 2:
					System.out.println("=======================Album List sorted by ArtistName================================");
					myDriver.sortByArtistName(listofAlbumSortByArtistName);
					myDriver.print(listofAlbumSortByArtistName);
					break;
				default:
					System.out.println("Wrong choice entered..Try again");
				
			}
			System.out.println("Do you want to continue y/n");
			ans = scanner.nextLine();
		}while(ans.equalsIgnoreCase("y"));

	}


	public void checkFile() throws IOException 
	{
		// Create an ArrayList for tracks 

		File aFile = new File("catalog.txt");
		String line, artistname, alblumname, songname; 

		if (!aFile.exists())
		{
			System.out.println("Sorry, file doesn't exit. Contact Support");
			System.exit(1);

		}
		else { System.out.println("File Exist");

		Scanner inputFile = new Scanner(aFile);
		List<Album> Catalog = new ArrayList(); 
		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			Scanner parseLine = new Scanner(line); // every time you call it it gives you one at a time 
			artistname = parseLine.next();
			alblumname = parseLine.next();
			List<Track> myTracks = null;
			//			myAlbum.setAlbumName(AlblumName);
			myTracks = new ArrayList(); 
			//			AlblumName = parseLine.next();
			while (parseLine.hasNext())
			{
				songname = parseLine.next();
				Track myTrack = new Track(songname);
				myTracks.add(myTrack);
				//  System.out.println(myTrack);
				//   System.out.println(myTracks);
			}
			Album myAlbum = new Album(alblumname,artistname, myTracks);
			//        listofAlbumSortByAlbumName.add(myAlbum);
			//			System.out.println(listofAlbumSortByAlbumName);
			Catalog.add(myAlbum);
			// System.out.println(myAlbum);

			//          Collections.sort(myTracks);

			//  System.out.println("-------");
			//   System.out.println(myTracks);


			// System.out.println(artistname);  
		}
		inputFile.close();
		listofAlbumSortByAlbumName.addAll(Catalog);
		listofAlbumSortByArtistName.addAll(Catalog);
		}

	}


	//public void sortAlbum()
	//
	//{
	//     Album myAlbum = new Album(AlblumName,ArtistName,myTracks);
	//     System.out.print("0000");
	//     System.out.print("0000"); 
	//    // Sort and Print  Albums
	//     
	//    // Print Artist 
	//    // Print Tracks 
	//    // Need a separate arraylist for Artist Name Order  artistname 
	//        
	//
	//}
	//
	//public void sortArtist()
	//{
	//    
	//    
	//     Collections.sort(Catalog, new AlbumComparator());
	//        for (Album sAlbums : Catalog)
	//        {
	//            System.out.println(sAlbums);
	//            
	//        }
	//   //Album //Alphepatic Order Artist // Song 
	//    
	//}
	/***
	 * Sort List of Track within each Album Object
	 * @param listofAlbum
	 */
	private void sortListOfTrack(List<Album> listofAlbum){
		for(int index = 0 ; index < listofAlbum.size();index++){
			List<Track> listofTrack = listofAlbum.get(index).getCollectionofTracks();
			Collections.sort(listofTrack);
		}
	}

	/***
	 * Sort the List of Album by Album Name,also sort the List of Track within each Album Object
	 * @param listofAlbum
	 */
	public void sortByAlbumName(List<Album> listofAlbum){
		sortListOfTrack(listofAlbum);
		Collections.sort(listofAlbum);
	}
	/***
	 * Sort the List of Album by Album Artist,also sort the List of Track within each Album Object
	 * @param listofAlbum
	 */
	public void sortByArtistName(List<Album> listofAlbum){
		sortListOfTrack(listofAlbum);
		Collections.sort(listofAlbum,new AlbumComparator());
	}

	/***
	 * Print the ListofAlbum to console
	 * @param listofAlbum
	 */
	public void print(List<Album> listofAlbum){
		for(int index = 0;index < listofAlbum.size();index++){
			Album album = listofAlbum.get(index);
			System.out.println(album.toString());
			System.out.println("List Of Tracks");
			List<Track> listofTracks = album.getCollectionofTracks();
			int listSize = listofTracks.size();
			for (int i = 0; i < listSize; i++) {
				System.out.println((i+1) + ")  " +listofTracks.get(i).toString());
			}
			System.out.println("********************************************************************************************************");
		}
	}
}
