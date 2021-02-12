/*
 * Created on 26.11.2004
 */
package de.laliluna.tutorial.library;

import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Map;


/**
 * @author laliluna.de
 */
public class Book implements Serializable {
	
	//	------------------ Properties  --------------------------------
	private long id;
	private String author;
	private String title;
	private boolean available;
	
	//	------------------ Constructors  --------------------------------
	public Book(){}
	public Book(long id, String author, String title, boolean available){ 
		this.id = id;
		this.author = author;
		this.title = title;
		this.available = available;
	}
	
	//	------------------ Getter and setter methods ---------------------
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	
	/**
	 * Set the properties
	 * @param book
	 */
	public void setBook(Book book){
		this.setId(book.getId());
		this.setAuthor(book.getAuthor());
		this.setTitle(book.getTitle());
		this.setAvailable(book.isAvailable());
	}
	
	/**
	 * @return book object 
	 */
	public Book getBook(){
		
		return new Book(this.getId(), 
						this.getAuthor(), 
						this.getTitle(), 
						this.isAvailable());
	}
	
	// ------------------ Action listener Methods ---------------------
	
	/**
	 * Initial the properties of the class with null
	 * 
	 * Initialisiert die Eigenschaften der Klasse mit null
	 * @param event
	 */
	public void initBook(ActionEvent event){
		
		/*
		 * init the book object
		 */
		this.setBook(new Book());
	}
	
	
	/**
	 * Get the book to edit and assign it to the bean
	 * 
	 * Liest das zu bearbeitende Buch aus 
	 * und weisst es dem Bean zu
	 * 
	 * @param event
	 */
	public void selectBook(ActionEvent event){
		
		SimulateDB simulateDB = new SimulateDB();
		
		/*
		 * Get the session map of the external context
		 * Holt sich die Session auf dem Externen Context
		 */
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		/* 
		 * Find the UIParameter component by expression
		 * Such die UIParameter Komponente anhand des Ausdrucks 
		 */
		UIParameter component = (UIParameter) event.getComponent().findComponent("editId");
		
		/*
		 * parse the value of the UIParameter component
		 * Parse den Value der UIParameter Komponente
		 */
		long id = Long.parseLong(component.getValue().toString());
		
		/*
		 * get the book by id and set it in the local property
		 * Lie� das Buch anhand der id aus und setze die lokalen Eigenschaften
		 */
		this.setBook(simulateDB.loadBookById(id, session));
	}
	
	/**
	 * Add or update the book in the simulated database.
	 * If the book id is not set the book will be added 
	 * otherwise the book will be updated
	 * 
	 * Legt oder aktualisiert ein Buch in der simulierten Datenbank
	 * Wenn die id des Buches nicht gesetzt ist wird das Buch 
	 * angelegt, ansonsten wird das Buch aktualsiert. 
	 * 
	 * @param event
	 */
	public void saveBook(ActionEvent event){
		
		SimulateDB simulateDB = new SimulateDB();
		
		/*
		 * Get the session map of the external context
		 * Holt sich die Session auf dem Externen Context
		 */
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		/*
		 * Add or update the book in the simulated database
		 * F�gt hinzu oder aktualisiert das Buch in der 
		 * simulierten Datenbank
		 */
		simulateDB.saveToDB(this.getBook(), session);
	}
	
	/**
	 * Delete a book in the simulated database
	 * 
	 * L�scht ein Buch aus der simulierten Datenbank
	 * 
	 * @param event
	 */
	public void deleteBook(ActionEvent event){
		
		SimulateDB simulateDB = new SimulateDB();
		
		/*
		 * Get the session map of the external context
		 * Holt sich die Session auf dem Externen Context
		 */
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		/* 
		 * Find the UIParameter component by expression
		 * Such die UIParameter Komponente anhand des Ausdrucks 
		 */
		UIParameter component = (UIParameter) event.getComponent().findComponent("deleteId");
		
		/*
		 * parse the value of the UIParameter component
		 * Parse den Value der UIParameter Komponente
		 */
		long id = Long.parseLong(component.getValue().toString());
		
		/*
		 * delete the book by id
		 * L�sche das Buch anhand der seiner id
		 */
		simulateDB.deleteBookById(id, session);
	}
	
}
