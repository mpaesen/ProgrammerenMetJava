package be;

import lotto.db.LottoSerializedFileIn;
import lotto.model.LottoCombination;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class GetLottoResults extends HttpServlet {

	// process "get" requests from clients
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(response);
	}

	private void processRequest(HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send XHTML page to client

		// start XHTML document
		out.println("<?xml version = \"1.0\"?>");

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD "
				+ "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");

		// head section of document
		out.println("<head>");
		out.println("<title>Get Lotto Results</title>");
		out.println("</head>");

		// body section of document
		out.println("<body>");
		out.println("<h1>Lotto!</h1>");
		try {
			showInput(out);
		} catch (FileNotFoundException e) {

			out.println(e.getMessage());
		} catch (IOException e) {

			out.println(e.getMessage());
		} catch (ClassNotFoundException e) {

			out.println(e.getMessage());
		}
		out.println("</body>");

		// end XHTML document
		out.println("</html>");
		out.close(); // close stream to complete the page
	}

	public static void showInput(PrintWriter out) throws IOException,
            ClassNotFoundException {

		LottoSerializedFileIn in = new LottoSerializedFileIn();
		String inputStream = "d:/temp/result.ser";
		ArrayList serializedList = in.getSerializedList(inputStream);

		in.fillUp(serializedList);

		LottoCombination actueelElement;
		for (Iterator it = serializedList.iterator(); it.hasNext();) {
			actueelElement = (LottoCombination) it.next();
			out.println(actueelElement.toString());
			out.println("<br>");
		}

	}

}

/*******************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and * Prentice Hall. All
 * Rights Reserved. * * DISCLAIMER: The authors and publisher of this book have
 * used their * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs * to
 * determine their effectiveness. The authors and publisher make * no warranty
 * of any kind, expressed or implied, with regard to these * programs or to the
 * documentation contained in these books. The authors * and publisher shall not
 * be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ******************************************************************************/
