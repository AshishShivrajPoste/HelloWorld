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
public class Track implements Comparable<Track> {
	String track; 
	public Track(String SongName)
	{
		track = SongName; 
	}
	public String getTrackName() {
		return track;
	}
	public void setTrackName(String track) {
		this.track = track;
	}
	public int compareTo(Track a, Track b) {
		return(a.track.compareToIgnoreCase(b.track)) ;
	}

	@Override
	public int compareTo(Track o) {
		Track othertrack = (Track) o;
		return track.compareToIgnoreCase(othertrack.track);

	}
	@Override
	public String toString() {
		return  track + "\n";
	}
}