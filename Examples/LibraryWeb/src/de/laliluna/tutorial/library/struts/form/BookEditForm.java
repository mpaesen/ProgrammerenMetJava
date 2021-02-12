
package de.laliluna.tutorial.library.struts.form;


import de.laliluna.tutorial.library.Book;
import org.apache.struts.action.ActionForm;


/** 
 * MyEclipse Struts
 * Creation date: 11-04-2004
 * 
 * XDoclet definition:
 * @struts:form name="bookEditForm"
 */
public class BookEditForm extends ActionForm {

	Book book = new Book();
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean equals(Object arg0) {
		return book.equals(arg0);
	}
	public String getAuthor() {
		return book.getAuthor();
	}
	public long getId() {
		return book.getId();
	}
	public String getTitle() {
		return book.getTitle();
	}
	public int hashCode() {
		return book.hashCode();
	}
	public boolean isAvailable() {
		return book.isAvailable();
	}
	public void setAuthor(String author) {
		book.setAuthor(author);
	}
	public void setAvailable(boolean available) {
		book.setAvailable(available);
	}
	public void setId(long id) {
		book.setId(id);
	}
	public void setTitle(String title) {
		book.setTitle(title);
	}
	public String toString() {
		return book.toString();
	}
}