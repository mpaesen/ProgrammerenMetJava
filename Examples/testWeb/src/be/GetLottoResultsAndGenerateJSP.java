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

public class GetLottoResultsAndGenerateJSP extends HttpServlet {

	// process "get" requests from clients
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html");
		try {
		LottoSerializedFileIn inputFile = new  LottoSerializedFileIn();
		// send XHTML page to client
		String inputStream = "d:/temp/result.ser";
		ArrayList serializedList = inputFile.getSerializedList(inputStream);		
		inputFile.fillUp(serializedList);
		request.setAttribute("inputFile", serializedList);
		// start XHTML document
			getServletContext().getRequestDispatcher("/LottoResultsFromServlet.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}

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
