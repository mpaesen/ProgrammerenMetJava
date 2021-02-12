/*
 * Created on Feb 18, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package database.datastore;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface SQLConstants {
	/*
	 * @ Screen Fields correspond with index.html page 
	 */
	public static final String[] FIELDS =
		{ "INSS", "FNAME", "LNAME", "OFFICE" };
	/*
	 * @ SQL Query Type
	 */
	public static final String[] QUERYTYPES = { "UPDATE", "SELECT" };
	/*
	 * @ Firma DADI
	 */
	public static final String DADI = "DADI";
	/*
	* @ Firma D012
	*/
	public static final String D012 = "D012";
	
		/*
	* @ Select *ALL
	*/
	public static final String ALL = "ALL";
	public static final String USERID = "user";
	public static final String PASSWORD = "password";
	public static final String DRIVER = "driver";
	public static final String URL = "url";
	public static final String POOL = "pool";
	public static final String JDBC = "jdbc";
	public static final String TYPE = "type";
	public static final String INITIALCONTEXTFACTORY = "initialContextFactory";
	public static final String LOOKUPURL = "lookupURL";
	public static final String LOOKUPNAME = "lookupName";
	public static final String DATABASE = "database";
	// default properties files
	public static final String file = "connection.properties";
	public static final String jdbcProps = "jdbc.properties";
	public static final String SQLfile = "SQLScripts.properties";	


}
