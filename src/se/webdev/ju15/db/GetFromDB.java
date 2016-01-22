package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import se.webdev.ju15.bean.DataBean;

public class GetFromDB {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:C:/Users/joaki/Desktop/Front-End/Projektuppgift_webdev/DB/TravelDb;create=true;";
	public static final String SQL_STATEMENT = "select * from STORIES";

	public ArrayList<DataBean> getDataFromDb() throws SQLException {

		ArrayList<DataBean> list = null;
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(SQL_STATEMENT);
			ResultSetMetaData rsMeta = resultSet.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			int rowCounter = 0;
			DataBean db = null;
			list = new ArrayList<DataBean>();
			
			while (resultSet.next()) {
				db = new DataBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				list.add(db);
	
				rowCounter++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
			}
		}
		
		return list;
	}
}