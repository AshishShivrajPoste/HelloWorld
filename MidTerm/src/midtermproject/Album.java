/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midtermproject;
import java.util.*;
/**
 *
 *
 */
public class Album implements Comparable<Album> {

	private String AlbumName;
	private String ArtistName;
	private List<Track> CollectionofTracks;


	public Album(String AlbumName, String ArtistName, List<Track> myTracks)
	{
		this.AlbumName = AlbumName;
		this.ArtistName = ArtistName;
		CollectionofTracks  = myTracks ;


	}
	public String getAlbumName()
	{
		return AlbumName;
	}
	public String getArtistName()
	{
		return ArtistName;
	}
	public void setArtistName(String ArtistName) {
		this.ArtistName = ArtistName;
	}

	public void setAlbumName(String AlbumName) {
		this.AlbumName = AlbumName    ;
	}

	public List<Track> getCollectionofTracks() {
		return CollectionofTracks;
	}
	public void setCollectionofTracks(List<Track> CollectionofTracks) {
		this.CollectionofTracks = (ArrayList<Track>) CollectionofTracks;
	}

	@Override
	public String toString() {
		return "Artist Name = " + ArtistName + "  AlbumName = " + AlbumName + "\n";
	}
	
	public void addtrack(Track T)
	{
		CollectionofTracks.add(T); 

	}

	public void sorttracks(Track T)
	{
		Collections.sort(CollectionofTracks);
	}
	@Override
	public int compareTo(Album catalog) {
		return this.AlbumName.compareToIgnoreCase(catalog.AlbumName);
	}






}


