package view;

import database.exceptions.DriverNotFound;
import model.HandelRequest;
import model.HandelResponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @version 	1.0
 * @author
 */
public class AdvantageServlet extends HttpServlet {
	private HandelRequest request;
	private HandelResponse response;
	/**
	 * 
	 */
	public AdvantageServlet() {
		super();

	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		processRequest(req, resp);
	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		processRequest(req, resp);
	}

	/**
	* @see javax.servlet.GenericServlet#java.lang.String ()
	*/
	public String getServletInfo() {

		return super.getServletInfo();

	}

	/**
	 * Method processRequest.
	 * @param req
	 * @param resp
	 */
	private void processRequest(
		HttpServletRequest req,
		HttpServletResponse resp)
		throws IOException, ServletException {
		request = new HandelRequest(req);
		response = new HandelResponse(resp, request.SQLParameters());
		HttpSession session = req.getSession(true);
		ServletContext context = getServletContext();

		try {
			session.setAttribute("resultBean", response.buildResultBean());
			context.getRequestDispatcher("Result.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("exception", e);
			context.getRequestDispatcher("Error.jsp").forward(req, resp);
		} finally {
			//close of sql Statement & connection
			try {
				response.close();
			} catch (DriverNotFound e1) {
				//e1.printStackTrace();
				session.setAttribute("exception", e1);
				context.getRequestDispatcher("Error.jsp").forward(req, resp);
			} catch (SQLException e1) {
				//e1.printStackTrace();
				session.setAttribute("exception", e1);
				context.getRequestDispatcher("Error.jsp").forward(req, resp);
			}
		}
	}
}
