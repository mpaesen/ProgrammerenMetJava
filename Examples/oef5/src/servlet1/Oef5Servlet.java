package servlet1;

import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;



/**
 * Servlet implementation class Oef5Servlet
 */
public class Oef5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oef5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//init
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//get the current hibernate session
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try
		{
			//strat the transaction
	        session.beginTransaction();
			
	        //create a new user object
	        User newUser = new User();
	        
		    //get strings from html document and set the user object with values
	        newUser.setFirstname(request.getParameter("firstName").toString());
	        newUser.setLastname(request.getParameter("surName").toString());
	    	newUser.setNummer(request.getParameter("nr").toString());
			newUser.setStraat(request.getParameter("straat").toString());
			newUser.setGemeente(request.getParameter("gemeente").toString());
			newUser.setPostcode(request.getParameter("postCode").toString());
				
			//saves the user object
	        session.save(newUser);
	
	        //if everything is ok > commit the transaction ...
	        session.getTransaction().commit();
		}
		catch (Exception e)
		{
			//else rollback
			session.getTransaction().rollback();
		}
		
			
		
		// print the results
		
		try 
		{

		    //create some headers and other stuff 
		    out.println("<html>");
			out.println("<head>");
			out.println("<title>DB information</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Al de gebruikers in: " + request.getContextPath () + "</h1>");
			
			//recreate the session
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			//start new transaction
			session.beginTransaction();
			
			//get all users from DB
			List results = session.createQuery("from User").list();
			//this is for debug reasons
			System.out.println( results.size() + " message(s) found:" );
			//commit the transaction
			session.getTransaction().commit();

			
			//get iterator
			for ( Iterator iter = results.iterator();
			
		    //loop through results and display all the results in the new page
			iter.hasNext();) 
			{
				User loadedUser = (User) iter.next();
				
				out.println("<p>Welcome " + loadedUser.getFirstname() + " " + loadedUser.getLastname() + "<br>" +
						" Wonende te: " + loadedUser.getPostcode() + " " + loadedUser.getGemeente() +  
						" in de " + loadedUser.getStraat() + " nr: " + loadedUser.getNummer()  + "</p>");
			}

		    
		    //close the page
			out.println("</body>");
			out.println("</html>");
			out.close();
			
	    
		} 
		catch (Exception e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	

}
