//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.1/xslt/JavaClass.xsl

package de.laliluna.tutorial.library.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * MyEclipse Struts
 * Creation date: 10-05-2004
 * 
 * XDoclet definition:
 * @struts:form name="bookListForm"
 */
public class BookListForm extends ActionForm {
    
	private Collection books;
  
	/* lalinuna.de 02.11.2004
	 * get the collection books
	 */
    public Collection getBooks() {
        return books;
    }
    /* lalinuna.de 02.11.2004
	 * set the collection books
	 */
    public void setBooks(Collection books) {
        this.books = books;
    }

    /* lalinuna.de 02.11.2004
	 * reset the collection books
	 */
    public void reset(ActionMapping arg0, HttpServletRequest arg1) {
        books = new ArrayList();
    }
}