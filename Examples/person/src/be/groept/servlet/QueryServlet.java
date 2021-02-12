package be.mySchool.servlet;

import be.mySchool.query.Database;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * 
 * @author Marlo Strouven maakt deel uit van de verbinding tussen browser en
 *         database
 * 
 */
public class QueryServlet extends HttpServlet {
	private Database database;

	private PrintWriter output;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		database = new Database();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		{
			String query = req.getParameter("query");
			String result = "";

			res.setContentType("text/html");
			output = res.getWriter();
			try {
				result = database.executeQuery(query, output);
			} catch (SQLException sqlex) {
				sqlex.printStackTrace(output);
				result = "er heeft zich een fout voorgedaan";
			}
			output.print(result);
			output.close();
		}
	}

	public void destroy() {
		database.close();
	}
}
