package com.groept.be.controller;

import com.groept.be.model.Visitor;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class BezoekerServlet
 */

public class BezoekerServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private VisitorService vservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BezoekerServlet() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	/*Hier maken we de service aan in de constructor van de servlet, in een real life application zou dit via de application context gebeuren*/
        vservice = new VisitorService();
    }
    
   

	/**
	 * Deze controller method zal ervoor zorgen dat een bezoeker zich kan aanmelden of doorverwezen wordt naar de registratie pagina.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ophalen input van de form
		String nick = request.getParameter("Nick");		
		
		
		if(nick != null && !nick.trim().equals(""))
		{
			/* Oproepen business logica */
			Visitor bezoeker = vservice.findVisitor(nick);
			if(bezoeker != null)
			{
			    HttpSession session = request.getSession(true);
			    session.setAttribute("bezoeker", bezoeker);
			
				/*Doorsturen van de request naar de jsp pagina om het resultaat te tonen*/
				request.setAttribute("Oproeper", "BezoekerServlet_get");
				
				getServletContext().getRequestDispatcher("/Bezoeker.jsp")
				.forward(request, response);
			}
			else
			{
				getServletContext().getRequestDispatcher("/RegisterBezoeker.jsp")
				.forward(request, response);
				
			}
		}
		else
		{
			request.setAttribute("Caller", "Login");
			getServletContext().getRequestDispatcher("/ErrorPage.jsp?")
			.forward(request, response);
		}
			
	}

	/**
	 * Deze controller method zal ervoor zorgen dat een bezoeker wordt geregistreerd in het systeem.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ophalen input van de form
		String name = request.getParameter("Name");
		String nick = request.getParameter("Nick");		
		
		
		if((name != null && !name.trim().equals(""))
				&&(nick != null && !nick.trim().equals("")))
		{
			/* Oproepen van business logica */
			Visitor bezoeker = vservice.createNewVisitor(name, nick);
			if(bezoeker != null)
			{
				 HttpSession session = request.getSession(true);
				 session.setAttribute("bezoeker", bezoeker);
			
				/*Doorsturen van de request naar de jsp pagina om het resultaat te tonen*/
				request.setAttribute("Oproeper", "BezoekerServlet_post");
				getServletContext().getRequestDispatcher("/Bezoeker.jsp")
				.forward(request, response);
			}
			else
			{
				request.setAttribute("Caller", "Create");
				getServletContext().getRequestDispatcher("/ErrorPage.jsp")
				.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("Caller", "Create");
			getServletContext().getRequestDispatcher("/ErrorPage.jsp")
			.forward(request, response);
		}
			
	}

}
