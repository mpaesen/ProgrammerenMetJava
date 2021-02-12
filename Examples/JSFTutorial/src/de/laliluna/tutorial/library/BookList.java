/*
 * Created on 26.11.2004
 */
package de.laliluna.tutorial.library;

import javax.faces.context.FacesContext;
import java.util.Collection;
import java.util.Map;

/**
 * @author laliluna.de
 */
public class BookList {

	// ------------------------- Properties ---------------------------
	Collection <Book>books;

	// ------------------------- Getter and Setter --------------------
	
	/**
	 * @return collection of books
	 */
	public Collection <Book>getBooks(){
		
		SimulateDB simulateDB = new SimulateDB();
		
		/* Get the session map of the external context 
		 * Holt sich die Session auf dem Externen Context
		 */
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		/* Get all books from the simulated database 
		 * Lies alle B�cher auf der simulierten Datenbank aus
		 */
		books = simulateDB.getAllBooks(session);
		
		return books;
	}
		
	/**
	 * @param books The books to set.
	 */
	public void setBooks(Collection <Book>books) {
		this.books = books;
	}	
}
