/**
 * 
 */
package database.connection;

import database.dao.DAOCustomer;
import database.sql.SQLStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author bempn
 * 
 */
public class CustomerDBController extends DBController{

	private ArrayList<DAOCustomer> customers;

	private ResultSet rs;
	private PreparedStatement pstmt;

	public DAOCustomer getCustomer(int id) throws SQLException {
		if (customers.isEmpty()) {
			DAOCustomer customer = null;
			rs = connectAndGetListOfEntities(SQLStatements.CUSTOMERS,
					"customers");
			while (rs.next()) {
				customer = new DAOCustomer(rs);
				customers.add(customer);
			}
			DatabaseConnectionController.closeResources(rs);			
		}
		return customers.get(id);
	}
	
	public void putCustomer(DAOCustomer id) throws SQLException {
		pstmt = null;
		pstmt = DatabaseConnectionController.getStatement(SQLStatements.ICUSTOMER);
		//Insert into from customer values(?, ?, ?, ?, ?)
		pstmt.setInt(1, id.getNumber());
		pstmt.setString(2, id.getName());
		pstmt.setString(3, id.getAddress());
		pstmt.setString(4, id.getTelephone());
		pstmt.setString(5, id.getEmail());
		pstmt.setString(6, id.getContactPersoon());
		
		
		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}


	public CustomerDBController() {

		customers = new ArrayList<DAOCustomer>();

	}
}
