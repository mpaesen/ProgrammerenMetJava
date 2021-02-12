/*
 * Created on Feb 16, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import database.exceptions.DriverNotFound;
import database.exceptions.SQLSyntaxException;
import database.exceptions.SyntaxException;
import database.jdbc.BuildSQLStatement;
import database.jdbc.DBController;
import view.ResultBean;

import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HandelResponse {
	private HttpServletResponse resp;
	private BuildSQLStatement sqlStatement;
	private ResultSetMetaData rsmd;
	private String[] parameterMarkers;
	/**
	 * 
	 */
	public HandelResponse(
		HttpServletResponse resp,
		String[] parameterMarkers) {
		super();
		this.resp = resp;
		this.parameterMarkers = parameterMarkers;
		sqlStatement = new BuildSQLStatement(parameterMarkers);
	}

	public ResultBean buildResultBean()
		throws SQLException, SQLSyntaxException, SyntaxException, DriverNotFound {
		ResultBean resultBean = new ResultBean();
		ResultSet resultSet = null;
		resultSet = processQuery(sqlStatement.getSQLStatement());

		rsmd = DBController.getRsmd();
		while (resultSet.next()) {
			resultBean.add(buildAdvantageCard(resultSet));
		}
		resultSet.close();
		
		//Office filled up
		String office = "";
		if (!parameterMarkers[3].equals("0")
			&& parameterMarkers[3].length() > 0) {
			resultSet = processQuery(sqlStatement.getSQLStatement(4, "OFFNME"));
			if (resultSet.next()) {
				office = resultSet.getBigDecimal(1).toString();
				office += " : "+resultSet.getString(2);
				resultSet.close();
			}
		}
		resultBean.setOffice(office);
		return resultBean;
	}

	private ResultSet processQuery(PreparedStatement sql)
		throws SQLException, SyntaxException, DriverNotFound, SQLSyntaxException {
		ResultSet resultSet;
		resultSet = DBController.processQuery(sql);

		if (resultSet == null)
			throw new SQLException(
				"No Records Found!\n"
					+ "Statement "
					+ sqlStatement.getSQLStatement());
		return resultSet;
	}
	/**
	 * Method buildAdvantageCard.
	 * @param req
	 * @return AdvantageCard
	 */
	private AdvantageCard buildAdvantageCard(ResultSet result)
		throws SQLException {
		AdvantageCard advantageCard =
			new AdvantageCard(
				result.getBigDecimal(1).intValue(),
				result.getString(2) + " " + result.getString(3),
				result.getBigDecimal(4).toString(),
				result.getString(5));

		return advantageCard;
	}
	
	public void close() throws DriverNotFound, SQLException{
		sqlStatement.close();
		DBController.close();
	}
}
