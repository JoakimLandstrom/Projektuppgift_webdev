package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import se.webdev.ju15.model.DataBean;

public class GetFromDB {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:/Users/daniel/Documents/Java/gitProjects/Projektuppgift_webdev/DB/TravelDb;create=true;";
	public static final String SQL_STATEMENT = "select * from stories";

	public ArrayList<DataBean> getDataFromDb() throws SQLException {

		ArrayList<DataBean> list = new ArrayList<DataBean>();
		Connection con = null;
		Statement stmt = null;
		DataBean db = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(SQL_STATEMENT);
			ResultSetMetaData rsMeta = resultSet.getMetaData();

			while (resultSet.next()) {
				System.out.println("getting beann");
				db = new DataBean(resultSet.getInt(1),resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getInt(5));
				list.add(db);
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