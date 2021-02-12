/*
 * Created on Feb 18, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package database.jdbc;

import database.datastore.SQLConstants;
import database.exceptions.DriverNotFound;
import database.exceptions.SQLSyntaxException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BuildSQLStatement implements SQLConstants {
	private String[] parameterMarkers;
	private PreparedStatement sql;

	/**
	 * @param parameterMarkers
	 */
	public BuildSQLStatement(String[] parameterMarkers) {
		super();
		this.parameterMarkers = parameterMarkers;
	}

	/**
	 * @param index
	 * @param key
	 * @return PreparedStatement
	 * @throws SQLException
	 * @throws DriverNotFound
	 * @throws SQLSyntaxException
	 */
	public PreparedStatement getSQLStatement(int index, String key)
		throws SQLException, DriverNotFound, SQLSyntaxException {

		//	No parameters read from input screen!		
		if (key == null || key.length() == 0) {
			key = ALL;
			index = 99;
		}
		
		//determine parametermarker	index
		String statement = DBController.getSQLStatement(key);

		sql = DatabaseManagement.getConnection().prepareStatement(statement);
		//sql.setString(1, parameterMarkers[index]);
		//sql.setBigDecimal(1, new BigDecimal(parameterMarkers[index]));
		return sql;
	}

	/**
	 * @return PreparedStatement
	 * @throws SQLException
	 * @throws DriverNotFound
	 * @throws SQLSyntaxException
	 */
	public PreparedStatement getSQLStatement()
		throws SQLException, DriverNotFound, SQLSyntaxException {
		int index = -1;
		String key = parameterMarkers[0];
		//	determine parametermarker
//		for (int i = 0; i < parameterMarkers.length; i++) {
//			if (!parameterMarkers[i].equals("")
//				&& !parameterMarkers[i].equals("0")
//				&& parameterMarkers[i].length() != 0) {
//				key = FIELDS[i];
//				index = i;
//				break;
//			}
//		}
		return getSQLStatement(index, key);
	}

	public void close() throws SQLException{
		sql.close();
		
	}
}
