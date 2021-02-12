package readmemo.model;

import com.ibm.as400.access.AS400JDBCDriver;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.*;

public class GetMemo {
	public static String getMemo(Connection conn, String library, String blobId){
		String memo = null;
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String blobTableName = null;
			pst = conn.prepareStatement("select FILE_BLOB_TABLENAME  from "+library+".FILEENTRY where FILE_ID =?");
			pst.setString(1,blobId);
			rs = pst.executeQuery();
			if (rs.next()){
				blobTableName = rs.getString("FILE_BLOB_TABLENAME");
			} else {
				blobTableName = "blobtable_1";
				System.out.println("Blobtable for id " + blobId + " not found, take default blobtable_1");
			}
			pst.close();
			StringBuffer buf = new StringBuffer();
			pst = conn.prepareStatement(("select BLOB_VALUE from " + library + "." + blobTableName + " where blob_id = ? "));
			pst.setString(1, blobId);
	
			rs = pst.executeQuery();
		
			if (rs.next()) {
				InputStream inputStream = new BufferedInputStream(rs.getBinaryStream("BLOB_VALUE"));
	
				byte[] b = new byte[4096];
	
				for (int n; (n = inputStream.read(b)) != -1;) {
					buf.append(new String(b, 0, n));
				}
			}
			memo = buf.toString();
		} catch (Exception e){
			System.out.println("Error while retrieving Memo...");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					rs = null;
					System.out.println("Error while retrieving Memo...");
					e.printStackTrace();
				}
			}
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					pst = null;
					System.out.println("Error while retrieving Memo...");
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					conn = null;
					System.out.println("Error while retrieving Memo...");
					e.printStackTrace();
				}
			}
		}
		
		return memo;
	}

	public static void main(String []args){
		String host = "bei5dev";
		String library = "ISISVDS";
		String username = "isis";
		String password = "xpress";
		Connection conn;

		try {
			DriverManager.registerDriver(new AS400JDBCDriver());
			conn = DriverManager.getConnection("jdbc:as400://"+host+"/" + library,  username, password);
			System.out.print(getMemo(conn, library, "e6ff0da1122cdf6844ab8000"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
