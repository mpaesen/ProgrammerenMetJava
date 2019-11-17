package be.mobyus;

import temperature.model.Conversion;
import temperature.model.Temperature;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version 1.0
 * @author
 */
public class TemperatureServlet extends HttpServlet {

	/**
	 * @see javax.servlet.http.HttpServlet
	 *      (javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		char inputValue;
		double doubleValue = 0.0;
		PrintWriter out = null;
		try {
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("<html>");

			out.println("Uw conversie: ");

			Temperature temp1, temp2, result;
			inputValue = Conversion.getWebSymbolInput(req
					.getParameter("fromTemp"));
			temp1 = Conversion.getWebInitialTemperature(req
					.getParameter("fromValue"), inputValue);
			inputValue = Conversion.getWebSymbolInput(req
					.getParameter("toTemp"));
			temp2 = Conversion.convertInitialTemperature(temp1, inputValue);
			out.println(temp1.toString() + " = " + temp2.toString());

		} catch (Exception e) {
			out.println(e.toString());
		} finally {
			out.println("</html>");
		}

	}

	/**
	 * @see javax.servlet.GenericServlet
	 */
	public void init() throws ServletException {

		super.init();

	}

}