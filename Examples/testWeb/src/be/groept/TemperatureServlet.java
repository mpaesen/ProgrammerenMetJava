package be.mySchool;

import temperature.model.Conversion;
import temperature.model.Temperature;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @version 1.0
 * @author
 */
public class TemperatureServlet extends HttpServlet {

	/**
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
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
	 */
	public void init() throws ServletException {

		super.init();

	}

}