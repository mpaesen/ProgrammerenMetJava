package com.ibm;

import java.io.Serializable;

public class Track implements Serializable, Playable{
	private String title;
	private int length;
	public Track() {
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void play()throws PlayerException{
		if(this.getLength()<=0){
			System.err.println("ERROR: Track Length is 0");
			throw (new PlayerException());
		}
		System.out.println("Playing Track: "+this.getTitle());
		System.out.println("Track length: "+this.getLength());

	}
	
	public String toString(){
		return "\n\t\tTrack :"+getTitle()+", length :"+getLength();
	}
}
