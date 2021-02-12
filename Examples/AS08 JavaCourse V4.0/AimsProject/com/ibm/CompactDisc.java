package com.ibm;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Media implements Playable{
	private String artist;
	private int length;
	private ArrayList tracks = new ArrayList();
	public CompactDisc() {
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void addTrack(Track track){
		if(!tracks.contains(track)){
			tracks.add(track);
		}
	}
	public void removeTrack(Track track){
		if(tracks.contains(track)){
			tracks.remove(track);
		}
	}
	public int getLength() {
		int length = 0;
		Iterator it = tracks.iterator();
		Track track;
		while(it.hasNext()){
			track= (Track)it.next();
			length += track.getLength();
		}
		return length;
	}
	
	public void play()throws PlayerException{
		if(this.getLength()<=0){
			System.err.println("ERROR: CD Length is 0");
			throw (new PlayerException());
		}

		System.out.println("Playing CD: "+this.getTitle());
		System.out.println("CD length: "+this.getLength());
		Track track;
		Iterator it = tracks.iterator();
		while(it.hasNext()){
			track = (Track)it.next();
			track.play();
		}
		
	}
	
	public int compareTo(Object medium){
		CompactDisc disc = (CompactDisc)medium;
		return this.getTitle().compareTo(disc.getTitle());
	}
	public String toString(){
		return "\nCD:"+super.toString()+"\n\tArtist :"+getArtist()+"\n\tTracks :"+tracks+"\n\tTotal length :"+getLength()+"\n";
	}
}
