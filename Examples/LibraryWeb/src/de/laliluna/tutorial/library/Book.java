/*
 * Created on 04.10.2004 by laliluna
 *
 */
package de.laliluna.tutorial.library;

/**
 * @author laliluna
 */
public class Book {

    private long id;
    private String title;
    private String author;
    private boolean available;

    // Contructor
    public Book(){}
    //  Contructor to initial the properties
    public Book(long id, String author, String title, boolean available) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}