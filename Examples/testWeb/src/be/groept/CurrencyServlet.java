package be.mySchool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @version 1.0
 * @author
 */
public class CurrencyServlet extends HttpServlet {

	/**
	 * @see javax.servlet.http.HttpServlet#void
	 *      (javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		try {
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("<html>");
			// out.println("<body bgcolor= &quot;Silver&quot; text=
			// &quot;#ffffff&quot;>");
			out.println("<body>");
			sp = SampleProperties.getPropertiesFile(req.getParameter("rates"));
			showRates(sp);
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
		}
	}

	private static void showRates(SampleProperties sp) {
		out.println("<u>");
		out.println("<b>");
		out.println("All known currencies:");
		out.println("</b>");
		out.println("</u>");
		out.println("<br>");
		// sp.listWeb(out);
		Object o = null;
		Enumeration currencies = sp.keys();
		out.println("<table border=1>");
		while (currencies.hasMoreElements()) {
			// out.println("<br>");
			out.println("<tr>");
			o = currencies.nextElement();
			out.println("<td width=120>");
			out.println(o.toString());
			out.println("</td>");
			out.println("<td width=80 align=right colspan=2>");
			out.println(sp.getProperty(o.toString()));
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("\nFor 3 Euro, you get " + 3
				* Float.parseFloat(sp.getProperty("currency.rate.euro2dollar"))
				+ " dollars");
	}

	/**
	 * @see javax.servlet.GenericServlet#void ()
	 */
	public void init() throws ServletException {

		super.init();

	}

	private static SampleProperties sp = null;

	private static PrintWriter out = null;
}