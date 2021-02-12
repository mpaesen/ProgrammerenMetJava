package com.ibm;

public class DigitalVideoDisc  extends Media implements  Playable  {
	private String director;
	private int length;
	public DigitalVideoDisc() {
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public String toString(){
		return "DVD:\n"+super.toString()+"\n\tDirector :"+getDirector()+"\n\tLength :"+getLength()+"\n";
	}
	public void play()throws PlayerException{
		if(this.getLength()<=0){
			System.err.println("ERROR: DVD Length is 0");
			throw (new PlayerException());
		}

		System.out.println("Playing DVD: "+this.getTitle());
		System.out.println("DVD length: "+this.getLength());
	}
	
	public int compareTo(Object medium){
		DigitalVideoDisc disc = (DigitalVideoDisc)medium;
		return this.getTitle().compareTo(disc.getTitle());
	}
}
