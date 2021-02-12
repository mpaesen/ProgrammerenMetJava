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

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


		//replace parameter markers with screen field	
		switch (index) {
			//INSS nummer
			case 0 :
				sql.setBigDecimal(1, new BigDecimal(parameterMarkers[index]));
				break;
			//Name or FirstName
			case 1 :
			case 2 :
				sql.setString(1, parameterMarkers[index] + "%");
				break;
			//Office
			case 3 :
				{
					sql = prepareOfficeData(index);
					break;
				}
			//All
			case 4 :
				{
					sql.setBigDecimal(1, new BigDecimal(parameterMarkers[index-1]));//office value
					break;
				}				
			default :
				break;
		}
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
		String key = null;
		//	determine parametermarker
		for (int i = 0; i < parameterMarkers.length; i++) {
			if (!parameterMarkers[i].equals("")
				&& !parameterMarkers[i].equals("0")
				&& parameterMarkers[i].length() != 0) {
				key = FIELDS[i];
				index = i;
				break;
			}
		}
		return getSQLStatement(index, key);
	}

	/**
	 * @param index
	 * @param office
	 * @return PreparedStatement
	 * @throws SQLException
	 * @throws DriverNotFound
	 * @throws SQLSyntaxException
	 */
	private PreparedStatement prepareOfficeData(int index)
		throws SQLException, DriverNotFound, SQLSyntaxException {
		// office selected
		String office = null;
		ResultSet rs;
		sql.setBigDecimal(1, new BigDecimal(parameterMarkers[index]));
		rs = sql.executeQuery();
		if (rs.next()) {
			switch (rs.getBigDecimal(1).intValue()) {
				case 1 :
					office = DADI;
					break;
				case 12 :
					office = D012;
					break;
				default :
					office = DADI;
					break;
			}
			close();
			sql =
				DatabaseManagement.getConnection().prepareStatement(
					DBController.getSQLStatement(office));
		} else {
			sql = null;

			throw new SQLSyntaxException(
				"Office " + office + " not found!\nSQL statement is " + sql);
		}
		sql.setBigDecimal(1, new BigDecimal(parameterMarkers[index]));
		return sql;
	}

	public void close() throws SQLException{
		sql.close();
		
	}
}
