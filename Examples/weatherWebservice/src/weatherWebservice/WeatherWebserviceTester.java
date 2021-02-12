package weatherWebservice;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherWebserviceTester
{

	public String getWeather(final String city) throws MalformedURLException, IOException
	{

		//Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		final String wsURL = "http://www.deeptraining.com/webservices/weather.asmx";
		final URL url = new URL(wsURL);
		final URLConnection connection = url.openConnection();
		final HttpURLConnection httpConn = (HttpURLConnection) connection;
		final ByteArrayOutputStream bout = new ByteArrayOutputStream();
		final String xmlInput = " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://litwinconsulting.com/webservices/\">\n" + " <soapenv:Header/>\n" + " <soapenv:Body>\n" + " <web:GetWeather>\n" + " <!--Optional:-->\n" + " <web:City>" + city
				+ "</web:City>\n" + " </web:GetWeather>\n" + " </soapenv:Body>\n" + " </soapenv:Envelope>";

		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		final byte[] b = bout.toByteArray();
		final String SOAPAction = "http://litwinconsulting.com/webservices/GetWeather";
		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		final OutputStream out = httpConn.getOutputStream();
		//Write the content of the request to the outputstream of the HTTP Connection.
		out.write(b);
		out.close();
		//Ready with sending the request.

		//Read the response.
		final InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		final BufferedReader in = new BufferedReader(isr);

		//Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null)
		{
			outputString = outputString + responseString;
		}
		//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
		final Document document = parseXmlFile(outputString);
		final NodeList nodeLst = document.getElementsByTagName("GetWeatherResult");
		final String weatherResult = nodeLst.item(0).getTextContent();
		System.out.println("Weather: " + weatherResult);

		//Write the SOAP message formatted to the console.
		final String formattedSOAPResponse = formatXML(outputString);
		System.out.println(formattedSOAPResponse);
		return weatherResult;
	}

	/*In the code above I make use of two util methods (final one that makes use of a Xerces.jar library, you can download it at http://xerces.apache.org/mirrors.cgi):
	**/
	//format the XML in your String
	public String formatXML(final String unformattedXml)
	{
		try
		{
			final Document document = parseXmlFile(unformattedXml);
			final OutputFormat format = new OutputFormat(document);
			format.setIndenting(true);
			format.setIndent(3);
			format.setOmitXMLDeclaration(true);
			final Writer out = new StringWriter();
			final XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);
			return out.toString();
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	private Document parseXmlFile(final String in)
	{
		try
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			final DocumentBuilder db = dbf.newDocumentBuilder();
			final InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		}
		catch (final ParserConfigurationException e)
		{
			throw new RuntimeException(e);
		}
		catch (final SAXException e)
		{
			throw new RuntimeException(e);
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	/*If you put this 3 methods together in a class with a main method, than you can simply call the weather webservice. Thats all!
	**/

	public static void main(final String[] args)
	{
		final WeatherWebserviceTester weatherWebserviceTester = new WeatherWebserviceTester();
		try
		{
			weatherWebserviceTester.getWeather("Brussels");
		}
		catch (final MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
