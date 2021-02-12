// $Id $
// (C) cantamen/Dirk Hillbrecht 2013. Released under the LGPL 2.0 or higher.
// Version: 2013-10-23-02
// For more information, contact info@cantamen.de or dh@cantamen.de. See http://www.cantamen.de
package iban.converter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.net.ssl.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/** Connector to IBAN conversion service from Theano GmbH/IBAN-BIC.com.
 *
 * This is a Java-6-SE-only class which connects to the IBAN conversion service of Theano GmbH as described on www.iban-bic.com.
 * It hides all the implementation of the connection behind some nice Java classes which do the dirty work.
 * <p>
 * Use this by creating one instance of the connector per thread and then calling generateIBAN() or another of the top level public
 * methods. The methods run synchronously and return either one of the defined result object (e.g. IBANReply) or throw an
 * IBANConverterException. Assuming the existance of some "BankAccountData" data type, a typical usage could be like this:
 *
 * <code>
IBANConverterServiceConnector connector=new IBANConverterServiceConnector("username","secret");
for (BankAccountData accountdata:getSomeBankAccountData(...whatever...)) {
  try {
    IBANConverterServiceConnector.IBANReply ibanreply=connector.generateIBAN(accountdata.getCountryCode(),accountdata.getBankCode(),accountdata.getAccountNumber());
    if (ibanreply.isPassed() && ibanreply.getResultCode()==0)
      accountdata.setIBAN(ibanreply.getIBAN());
    else {
      accountdata.setProbableIBAN(ibanreply.getIBAN());
      accountdata.setIBANResultCode(ibanreply.getResultCode());
    }
  }
  catch (IBANConverterException ice) {
    accountdata.setIBANConversionProblem(ice);
  }
}</code>
 *
 * The class contains some static helper classes for result and exception transport. It is fully self-contained with no other external references but the Java 6 SE
 * runtime environment.
 * <p>
 * Internally, IBANConverterServiceConnector connects to the service via its HTTP-based interface. It passes the information through URL parameters and receives
 * the reply as XML string in the HTTP query response. That one is converted into a DOM tree from where the reply data is extracted and stored in the reply class.
 * The class does not use any SOAP or other frameworks above the W3C DOM system.
 *
 * @author (C) cantamen/Dirk Hillbrecht 2013. Released under the LGPL 2.0 or higher. For more information, contact info@cantamen.de or dh@cantamen.de. See http://www.cantamen.de
 * @version $Id $
 */
public class IBANConverterServiceConnector
{

	// **************************************************
	// *** Public interface and public helper classes ***
	// **************************************************

	/** Global flag to set this into debug mode.
	 *
	 * If set to true, the whole connector does <em>not</em> query the conversion service over the web, but simply returns a precompiled answer.
	 * Set this to true during development and debugging so that you do not call the service everytime you run your tests. In production environments,
	 * this should always be set to false.
	 */
	private static final boolean DEBUG = false;

	/** Instantiate a service connector for the IBAN conversion.
	 *
	 * Converters are single-threaded! It takes the username/password information which are used for all ongoing queries.
	 *
	 * @param usernamex Username to use for the IBAN conversion service
	 * @param passwordx Passwort for authenticating to the IBAN conversion service
	 */
	public IBANConverterServiceConnector(final String usernamex, final String passwordx)
	{
		username = usernamex;
		password = passwordx;
		/* - This is for password hashing which does not seem to work on Java
		try {
		  md5 = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
		  throw new IllegalStateException("error.nomd5digesterfound",e);
		}
		*/
		dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setIgnoringComments(false);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(true);
		// dbf.setCoalescing(true);
		// dbf.setExpandEntityReferences(true);

	}

	/** Special exception class for signalling problems with the IBAN conversion.
	 *
	 * This exception is thrown if something goes severely wrong with the IBAN conversion. It is only thrown if the service is cannot be connected
	 * or returns syntactically unexpected replies. If the IBAN was incontructible from the given data, no exception is thrown but instead a reply
	 * is returned which describes the problems.
	 * <p>
	 * This exceptions is derived from RuntimeException so that you might more or less "ignore" it while coding. You should not do, however, as such
	 * behaviour will always bite you and your project when you do not expect it.
	 */
	public static class IBANConverterException extends RuntimeException
	{
		public IBANConverterException(final String s)
		{
			super(s);
		}

		public IBANConverterException(final String s, final Throwable c)
		{
			super(s, c);
		}
	}

	/** Reply class for IBAN query results.
	 *
	 * This class is returned by generateIBAN() and friends. It contains the - probably - generated IBAN and other values as they are returned by the
	 * IBAN conversion web service. An instance of this class is immutable.
	 */
	public static class IBANReply
	{
		private final String iban;
		private final boolean passed;
		private final int resultcode;
		private final int balance;

		public IBANReply(final String ibanx, final boolean passedx, final int resultcodex, final int balancex)
		{
			iban = ibanx;
			passed = passedx;
			resultcode = resultcodex;
			balance = balancex;
		}

		/** Return the IBAN as created by the service. */
		public String getIBAN()
		{
			return iban;
		}

		/** Return whether the IBAN generation passed or failed ("result" value of the IBAN creation service) */
		public boolean isPassed()
		{
			return passed;
		}

		/** Return the result code as generated by the IBAN creation service. */
		public int getResultCode()
		{
			return resultcode;
		}

		/** Returns the account balance information from the IBAN creation service. */
		public int getBalance()
		{
			return balance;
		}

		/** Return a string representation. */
		@Override
		public String toString()
		{
			return "{IBANReply, passed: " + passed + ", result code: " + resultcode + ", IBAN: " + iban + ", balance: " + balance + "}";
		}
	}

	/** Builder for the IBANReply class. */
	private static class IBANReplyBuilder
	{
		private String iban = "";

		public IBANReplyBuilder setIBAN(final String ibanx)
		{
			iban = ibanx;
			return this;
		}
		private boolean passed = false;

		public IBANReplyBuilder setResult(final String resultstring)
		{
			passed = "passed".equalsIgnoreCase(resultstring);
			return this;
		}
		private int resultcode = -1;

		public IBANReplyBuilder setResultCode(final String resultcodestring)
		{
			resultcode = Integer.parseInt(resultcodestring);
			return this;
		}
		private int balance = -1;

		public IBANReplyBuilder setBalance(final String balancestring)
		{
			balance = Integer.parseInt(balancestring);
			return this;
		}

		public IBANReply build()
		{
			return new IBANReply(iban, passed, resultcode, balance);
		}
	}

	/** Convert a legacy German bankcode/account pair to an IBAN.
	 *
	 * This method gets a german bank account at a German bank and returns the IBAN for this account. The result also contains result and error codes of
	 * the conversion.
	 *
	 * @param bankcode Bank code of the account to convert
	 * @param account Account number
	 * @returns IBANReply instance with the generated IBAN or the appropriate error information if no IBAN was created.
	 */
	public IBANReply generateGermanIBAN(final String bankcode, final String account) throws IBANConverterException
	{
		return generateIBAN("DE", bankcode, account);
	}

	/** Convert a legacy bankcode/account pair to an IBAN.
	 *
	 * This method gets a bank account at a bank in the country given by the country code and returns the IBAN for this account.
	 * The result also contains result and error codes of the conversion.
	 *
	 * @param countrycode 2-character ISO country code of the account's and bank's country
	 * @param bankcode Bank code of the account to convert
	 * @param account Account number
	 * @returns IBANReply instance with the generated IBAN or the appropriate error information if no IBAN was created.
	 */
	public IBANReply generateIBAN(final String countrycode, final String bankcode, final String account) throws IBANConverterException
	{
		try
		{
			Document reply;
			if (DEBUG)
			{
				System.err.println("IBAN converter in DEBUG MODE!!!");
				reply = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(debugresult.getBytes()));
			}
			else
			{
				final URL url = new URL(generateCalculateIBANURL(countrycode, bankcode, account));
				final HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
				try
				{
					// Here we set the special socket factory for accessing the IBAN service
					con.setSSLSocketFactory(ibanrechnersslcontext.getSocketFactory());
					if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
						throw new IllegalStateException("error.httpnotok|" + con.getResponseCode() + "|" + con.getResponseMessage());
					// We have to remove any leading empty lines from the body as this confuses the DOM parser. So, eat up characters until "<" appears.
					final PushbackInputStream pbis = new PushbackInputStream(con.getInputStream());
					int ch;
					while ((ch = pbis.read()) == '\n')
					{
					}
					pbis.unread(ch);
					reply = dbf.newDocumentBuilder().parse(pbis);
				}
				finally
				{
					con.disconnect();
				}
			}
			if (reply == null)
				throw new IllegalStateException("error.noreply");
			final Node result = reply.getFirstChild();
			if (result == null)
				throw new IllegalStateException("error.noresultnode");
			if (!"result".equals(result.getNodeName()))
				throw new IllegalStateException("error.resultnodename|" + result.getNodeName());

			final IBANReplyBuilder builder = new IBANReplyBuilder();
			final NodeList nl = result.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++)
			{
				final Node n = nl.item(i);
				//System.out.println("Node "+i+": "+nl.item(i).getNodeName());
				if ("iban".equals(n.getNodeName()))
					builder.setIBAN(n.getFirstChild().getNodeValue());
				else if ("result".equals(n.getNodeName()))
					builder.setResult(n.getFirstChild().getNodeValue());
				else if ("return_code".equals(n.getNodeName()))
					builder.setResultCode(n.getFirstChild().getNodeValue());
				else if ("balance".equals(n.getNodeName()))
					builder.setBalance(n.getFirstChild().getNodeValue());
			}
			return builder.build();
		}
		catch (final Exception e)
		{
			throw new IBANConverterException("Access problem occurred", e);
		}

	}

	// *********************************************
	// *** Static internal operation environment ***
	// *********************************************

	/** Specially crafted result returned in debug mode regardless of account data given for IBAN conversion. */
	private static final String debugresult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<result><iban>DE74250501800012345678</iban><result>passed</result><return_code>0</ret" + "urn_code><ibanrueck_return_code></ibanrueck_return_code><checks-list><checks>length</"
			+ "checks><checks>bank_code</checks><checks>account_number</checks></checks-list><bic_ca" + "ndidates-list><bic_candidates><bic>SPKHDE2HXXX</bic><zip>30001</zip><city>Hannover</c" + "ity><wwwcount>0</wwwcount><sampleurl></sampleurl></bic_candidates></bic_candidates-li"
			+ "st><country>DE</country><bank_code>25050180</bank_code><alternative_bank_code></alter" + "native_bank_code><bank>Sparkasse Hannover</bank><bank_address></bank_address><bank_ur" + "l></bank_url><branch></branch><branch_code></branch_code><in_scl_directory>yes</in_sc"
			+ "l_directory><sct>yes</sct><sdd>yes</sdd><b2b>yes</b2b><account_number>12345678</accou" + "nt_number><alternative_account_number></alternative_account_number><account_validatio" + "n_method>A3</account_validation_method><account_validation>Methode 10, Konto 00123456"
			+ "78, BLZ 25050180, Prüfziffer 7 steht an Position 10, erwartete Prüfziffer: 7. Überbli" + "ck über die Berechnung: Nimm die Ziffern auf den Positionen 1 bis 9 - hier: 001234567" + " -, multipliziere sie von rechts nach links mit den Gewichten 2,3,4,5,6,7,8,9,10, add"
			+ "iere die Produkte, bilde den Rest der Division durch 11, ziehe das Ergebnis von 11 ab" + ",  und das Ergebnis modulo 11 ist die erwartete Prüfziffer.</account_validation><leng" + "th_check>passed</length_check><account_check>passed</account_check><bank_code_check>p"
			+ "assed</bank_code_check><bic_plausibility_check></bic_plausibility_check><data_age>201" + "30805</data_age><IBANformat>DEkk BBBB BBBB CCCC CCCC CC</IBANformat><formatcomment>B " + "= sort code (BLZ), C = account No.</formatcomment><balance>0</balance></result>";

	/** Trust manager for https://ssl.ibanrechner.de
	 *
	 * That system, which implements the IBAN conversion service, uses a certificate which is not signed by a CA known to the Java Runtime Environment.
	 * So, we implement our own trust manager which trusts only exactly one certificate: That one of ssl.ibanrechner.de.
	 */
	private static class IBANRechnerTrustManager implements X509TrustManager
	{

		/** The certificate has been loaded directly from ssl.ibanrechner.de. */
		private static String ibanservercertstring = "-----BEGIN CERTIFICATE-----\n" + "MIIJqjCCCJKgAwIBAgICBeUwDQYJKoZIhvcNAQEFBQAwgYExCzAJBgNVBAYTAklM\n" + "MRYwFAYDVQQKEw1TdGFydENvbSBMdGQuMSkwJwYDVQQLEyBTdGFydENvbSBDZXJ0\n" + "aWZpY2F0aW9uIEF1dGhvcml0eTEvMC0GA1UEAxMmU3RhcnRDb20gRXh0ZW5kZWQg\n"
				+ "VmFsaWRhdGlvbiBTZXJ2ZXIgQ0EwHhcNMTIwNzAxMDIyNzI2WhcNMTQwNzAzMDUy\n" + "NTEwWjCCAV0xGTAXBgNVBA0TEEs5TGIzMDJtS1Z5UVM1TVgxCzAJBgNVBAYTAkRF\n" + "MRYwFAYDVQQIEw1OaWVkZXJzYWNoc2VuMRIwEAYDVQQHEwlIYXNiZXJnZW4xDjAM\n" + "BgNVBBETBTQ5MjA1MRUwEwYDVQQJEwxLaWVmZXJud2VnIDgxFDASBgNVBAoTC1Ro\n"
				+ "ZWFubyBHbWJIMRswGQYDVQQDExJzc2wuaWJhbnJlY2huZXIuZGUxKDAmBgkqhkiG\n" + "9w0BCQEWGXBvc3RtYXN0ZXJAaWJhbnJlY2huZXIuZGUxEzARBgNVBAUTCkhSQiAy\n" + "MDU0MzYxHTAbBgNVBA8TFFByaXZhdGUgT3JnYW5pemF0aW9uMRowGAYLKwYBBAGC\n" + "NzwCAQEUCU9zbmFicvxjazEeMBwGCysGAQQBgjc8AgECEw1OaWVkZXJzYWNoc2Vu\n"
				+ "MRMwEQYLKwYBBAGCNzwCAQMTAkRFMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB\n" + "CgKCAQEApNXKYi+/ifySs2swAb6PaLQ1gO2SkdJwF5rks81TEQMRCgBeC+oCNJ/6\n" + "e+nNHu8v8nybIH3liFnAhpkjYUkQMz9Z3CsBETtfkOVB0alOcSqpOwRmojZ/NruZ\n" + "sfuGcnrNhAs0l8bwFCEMOH9YGxP4O28QXlN/9kPvEGc7WynamNNlXfFqsNMFdixu\n"
				+ "DdEMWO2PkDHxfY+ZbgHVtYxYgaPP/gDLBFov23WDAOz2mkSwvgykg9MK2myaluq6\n" + "3MhWRbR8z6uTJTEQ0oir+28BK59EBuzgEWKlWwe3xBo171MFYgXL00IVUAP0lDd6\n" + "LImD9srrY6BeV+03QX+1HP/KjiHGdQIDAQABo4IFSzCCBUcwCQYDVR0TBAIwADAL\n" + "BgNVHQ8EBAMCA6gwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMBMB0GA1Ud\n"
				+ "DgQWBBSFgs0yimIu/GZxNQ5r3TaZmtL2DTAfBgNVHSMEGDAWgBSh4Z5FJXlNBtkC\n" + "F5KC1TCJciUUoDCCAWsGA1UdEQSCAWIwggFeghJzc2wuaWJhbnJlY2huZXIuZGWC\n" + "DmliYW5yZWNobmVyLmRlggxpYmFuLWJpYy5jb22CEWJhazEuaWJhbi1iaWMuY29t\n" + "ghFiYWsyLmliYW4tYmljLmNvbYIJdGhlYW5vLmRlgg1zc2wudGhlYW5vLmRlghBk\n"
				+ "ZXYuaWJhbi1iaWMuY29tghBzc2wuaWJhbi1iaWMuY29tghJpYmFuY2FsY3VsYXRv\n" + "ci5jb22CFnNzbC5pYmFuY2FsY3VsYXRvci5jb22CD2liYW4tcmVjaG5lci5kZYIT\n" + "c3NsLmliYW4tcmVjaG5lci5kZYIUbm9jaGJpbGxpZ2VyZmF4ZW4uZGWCGHd3dy5u\n" + "b2NoYmlsbGlnZXJmYXhlbi5kZYIMc2VwYXRvb2xzLmV1ghFiYWsxLnNlcGF0b29s\n"
				+ "cy5ldYIRYmFrMi5zZXBhdG9vbHMuZXWCEHNzbC5zZXBhdG9vbHMuZXUwggJwBgNV\n" + "HSAEggJnMIICYzALBgkrBgEEAYG1NwIwDQYLKwYBBAGBtTcBAQEwggJDBgsrBgEE\n" + "AYG1NwECAjCCAjIwLgYIKwYBBQUHAgEWImh0dHA6Ly93d3cuc3RhcnRzc2wuY29t\n" + "L3BvbGljeS5wZGYwNAYIKwYBBQUHAgEWKGh0dHA6Ly93d3cuc3RhcnRzc2wuY29t\n"
				+ "L2ludGVybWVkaWF0ZS5wZGYwMAYIKwYBBQUHAgEWJGh0dHA6Ly93d3cuc3RhcnRz\n" + "c2wuY29tL2V4dGVuZGVkLnBkZjCB+AYIKwYBBQUHAgIwgeswJxYgU3RhcnRDb20g\n" + "Q2VydGlmaWNhdGlvbiBBdXRob3JpdHkwAwIBARqBv1RoaXMgY2VydGlmaWNhdGUg\n" + "d2FzIGlzc3VlZCBhY2NvcmRpbmcgdG8gdGhlIEV4dGVuZGVkIFZhbGlkYXRpb24g\n"
				+ "cmVxdWlyZW1lbnRzIG9mIHRoZSBTdGFydENvbSBDQSBwb2xpY3ksIHJlbGlhbmNl\n" + "IG9ubHkgZm9yIHRoZSBpbnRlbmRlZCBwdXJwb3NlIGluIGNvbXBsaWFuY2Ugb2Yg\n" + "dGhlIHJlbHlpbmcgcGFydHkgb2JsaWdhdGlvbnMuMIGcBggrBgEFBQcCAjCBjzAn\n" + "FiBTdGFydENvbSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTADAgECGmRMaWFiaWxp\n"
				+ "dHkgYW5kIHdhcnJhbnRpZXMgYXJlIGxpbWl0ZWQhIFNlZSBzZWN0aW9uICJMZWdh\n" + "bCBhbmQgTGltaXRhdGlvbnMiIG9mIHRoZSBTdGFydENvbSBDQSBwb2xpY3kuMDUG\n" + "A1UdHwQuMCwwKqAooCaGJGh0dHA6Ly9jcmwuc3RhcnRzc2wuY29tL2NydDQtY3Js\n" + "LmNybDCBjgYIKwYBBQUHAQEEgYEwfzA5BggrBgEFBQcwAYYtaHR0cDovL29jc3Au\n"
				+ "c3RhcnRzc2wuY29tL3N1Yi9jbGFzczQvc2VydmVyL2NhMEIGCCsGAQUFBzAChjZo\n" + "dHRwOi8vYWlhLnN0YXJ0c3NsLmNvbS9jZXJ0cy9zdWIuY2xhc3M0LnNlcnZlci5j\n" + "YS5jcnQwIwYDVR0SBBwwGoYYaHR0cDovL3d3dy5zdGFydHNzbC5jb20vMA0GCSqG\n" + "SIb3DQEBBQUAA4IBAQCF4VcMd0hbSOUPPKfAnBzAOAIC/Vboe/CX+txikFhx2Thv\n"
				+ "i7GY2W7GfYAbS6ZgmFTwXN1RwUKmQi0e1x9dKRK7iT45R1r7qMBXFAYUnzidlx+0\n" + "tHVbdS3UvOa+1SoInEKogR9hxxnVO3x4zVJCRsMzFVwj8rRxeKsNT15+SUNRC26s\n" + "j67cqtRWZk3b71xssl0ZjYtH3x5sOvpZOb6gelGZ1cSscoIeCIjPm8/nCvgTspNu\n" + "BfFmhb73VSTm9/25GA2FMtd7Lx6qGJwofxFPCZx+oLQjpjYK+qMeijOTdQGAV1QM\n"
				+ "gnyL5ADQPfQoIBolCEB6XGN614r0ydM8wh6QgIib\n" + "-----END CERTIFICATE-----\n";

		private X509TrustManager pkixTrustManager;

		public IBANRechnerTrustManager() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
		{

			// This code is ruthlessly borrowed from StackOverflow, http://stackoverflow.com/questions/3247746/java-loading-ssl-keystore-via-a-resource

			final Certificate ibanrechnercert = CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(ibanservercertstring.getBytes()));

			final KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(null, "".toCharArray());
			keyStore.setCertificateEntry("ibanrechner.de", ibanrechnercert);

			final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX");
			trustManagerFactory.init(keyStore);

			final TrustManager trustManagers[] = trustManagerFactory.getTrustManagers();

			for (final TrustManager trustManager : trustManagers)
			{
				if (trustManager instanceof X509TrustManager)
				{
					pkixTrustManager = (X509TrustManager) trustManager;
					return;
				}
			}

			throw new IllegalStateException("error.couldnotinit"); // Must not happen
		}

		public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException
		{
			pkixTrustManager.checkServerTrusted(chain, authType);
		}

		public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException
		{
			pkixTrustManager.checkServerTrusted(chain, authType);
		}

		public X509Certificate[] getAcceptedIssuers()
		{
			return pkixTrustManager.getAcceptedIssuers();
		}
	}

	/** SSL context for establishing a connection to the service. */
	private static SSLContext ibanrechnersslcontext;

	static
	{
		// Instantiate the SSL context once and for all
		try
		{
			ibanrechnersslcontext = SSLContext.getInstance("SSL");
			ibanrechnersslcontext.init(null, new TrustManager[] { new IBANRechnerTrustManager() }, null);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Common first part of URL to access IBAN conversion service. */
	private static final String URLBASE = "https://ssl.ibanrechner.de/http.html?";

	// *******************************************
	// *** Internal helper classes and methods ***
	// *******************************************

	/** Username for talking to the IBAN conversion service. */
	private final String username;

	/** Passwort for authentication against the IBAN conversion service. */
	private final String password;

	// /** Common digester for creating the password hash for the queries. */
	// private final MessageDigest md5;  - This does not seem to work

	/** XML document builder factory for the Java DOM framework */
	private final DocumentBuilderFactory dbf;

	/** Generate the URL for querying an IBAN from a bankcode and a bank account number. */
	private String generateCalculateIBANURL(final String countrycode, final String bankcode, final String account)
	{
		// This does not seem to work with Java's md5() function.
		//String pwhash=DatatypeConverter.printHexBinary(md5.digest(new StringBuilder().append("calculate_iban").append(username).append(account).append(password).toString().getBytes()));
		return URLBASE + "function=calculate_iban&country=" + countrycode + "&bankcode=" + bankcode + "&account=" + account + "&user=" + username + "&password=" + password;
	}

	// **************************
	// *** Debug main program ***
	// **************************

	/** Test main program. To be removed once everything is working. */
	public static void main(final String[] args)
	{
		if (args.length < 5)
			System.out.println("Usage: " + IBANConverterServiceConnector.class.getName() + " country_code bank_code account_number username password");
		else
			System.out.println(new IBANConverterServiceConnector(args[3], args[4]).generateIBAN(args[0], args[1], args[2]).toString());
	}

}

// end of file
