package lotto.view;

import lotto.db.LottoSerializedFileIn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GetLottoResultsAndGenerateJSP extends HttpServlet
{
	final String inputStream = "/Users/mpaesen/Documents/workspace/exampleJSP/result.ser";

	// process "get" requests from clients
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	private void processRequest(final HttpServletRequest request, final HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		try
		{
			final LottoSerializedFileIn inputFile = new LottoSerializedFileIn();
			// send XHTML page to client
			//			System.out.println(System.getProperty("user.dir"));

			final ArrayList serializedList = inputFile.getSerializedList(inputStream);
			inputFile.fillUp(serializedList);
			request.setAttribute("inputFile", serializedList);
			// start XHTML document
			getServletContext().getRequestDispatcher("/LottoResultsFromServlet.jsp").forward(request, response);
		}
		catch (final ServletException e)
		{
			e.printStackTrace();
		}
		catch (final FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		catch (final ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}