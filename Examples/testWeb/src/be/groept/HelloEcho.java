package be.mySchool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @version 1.0
 * @author
 */
public class HelloEcho extends HttpServlet {

	/**
	 * @see javax.servlet.http.HttpServlet#void
	 *      (javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest servRequest,
			HttpServletResponse servResponse) throws ServletException {
		try {
			servResponse.setContentType("text/html");
			PrintWriter out = servResponse.getWriter();
			out.println("<html>");

			out.println("You said hello by typing: "
					+ servRequest.getParameter("toEcho"));

			out.println("</html>");
		} catch (Exception e) {
		}

	}

	/**
	 * @see javax.servlet.GenericServlet#void ()
	 */
	public void init() throws ServletException {

		super.init();

	}

}