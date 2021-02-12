//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.0/xslt/JavaClass.xsl

package de.laliluna.tutorial.library.struts.action;

import de.laliluna.tutorial.library.SimulateDB;
import de.laliluna.tutorial.library.struts.form.BookEditForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * MyEclipse Struts
 * Creation date: 11-04-2004
 * 
 * XDoclet definition:
 * @struts:action path="/bookEdit" name="bookEditForm" parameter="do" scope="request" validate="true"
 * @struts:action-forward name="/jsp/bookEdit.jsp" path="/jsp/bookEdit.jsp"
 */
public class BookEditAction extends DispatchAction {

	/** 
	 * Method editBook
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward editBook(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		BookEditForm bookEditForm = (BookEditForm) form;
		
		/* lalinuna.de 04.11.2004
		 * get id of the book from request
		 */
		long id = Long.parseLong(request.getParameter("id"));
		
		/* lalinuna.de 04.11.2004
		 * init SimulateDB class and get book id
		 */
		SimulateDB simulateDB = new SimulateDB();
		bookEditForm.setBook(simulateDB.loadBookById(id, request.getSession()));
		
		return mapping.findForward("showEdit");
		
	}
	
	/** 
	 * Method deleteBook
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward deleteBook(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		BookEditForm bookEditForm = (BookEditForm) form;
		
		/* lalinuna.de 04.11.2004
		 * get id of the book from request
		 */
		long id = Long.parseLong(request.getParameter("id"));
		
		/* lalinuna.de 04.11.2004
		 * init SimulateDB class and delete book by id
		 */
		SimulateDB simulateDB = new SimulateDB();
		simulateDB.deleteBookById(id, request.getSession());
		
		return mapping.findForward("showList");
		
	}
	
	/** 
	 * Method addBook
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addBook(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		BookEditForm bookEditForm = (BookEditForm) form;
		
		return mapping.findForward("showAdd");
		
	}
	
	/** 
	 * Method saveBook
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward saveBook(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		BookEditForm bookEditForm = (BookEditForm) form;
		
		/* lalinuna.de 04.11.2004
		 * init SimulateDB class and get data by id
		 */
		SimulateDB simulateDB = new SimulateDB();
		simulateDB.saveToDB(bookEditForm.getBook(), request.getSession());
		
		return mapping.findForward("showList");
		
	}

}