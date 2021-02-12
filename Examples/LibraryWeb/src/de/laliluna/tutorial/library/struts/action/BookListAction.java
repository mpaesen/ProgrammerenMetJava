//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.0/xslt/JavaClass.xsl

package de.laliluna.tutorial.library.struts.action;

import de.laliluna.tutorial.library.SimulateDB;
import de.laliluna.tutorial.library.struts.form.BookListForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * MyEclipse Struts
 * Creation date: 11-03-2004
 * 
 * XDoclet definition:
 * @struts:action path="/bookList" name="bookListForm" input="/jsp/bookList.jsp" scope="request"
 * @struts:action-forward name="/jsp/bookList.jsp" path="/jsp/bookList.jsp"
 */
public class BookListAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		BookListForm bookListForm = (BookListForm) form;
		
		
		/* lalinuna.de 03.11.2004
		 * init SimulateDB class and set some dummy data
		 */
		SimulateDB simulateDB = new SimulateDB();
	    bookListForm.setBooks(simulateDB.getAllBooks(request.getSession()));

	    
	    return mapping.findForward("showList");
	}
	
}