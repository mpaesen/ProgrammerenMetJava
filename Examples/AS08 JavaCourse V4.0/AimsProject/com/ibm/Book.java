package com.ibm;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList authors = new ArrayList();
	
	public Book() {
		super();
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName))
			authors.add(authorName);
	}
	
	public void removeAuthor(String authorName){
        authors.remove(authorName);
	}
	
	public int compareTo(Object medium){
		Book disc = (Book)medium;
		return this.getTitle().compareTo(disc.getTitle());
	}

	public String toString(){
		return "Book:\n" + super.toString()+"\n\tAuthors :"+authors+"\n";
	}
}
