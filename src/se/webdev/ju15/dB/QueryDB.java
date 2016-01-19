package se.webdev.ju15.dB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.tools.sysinfo;

public class QueryDB {
	public static final String SQL_STATEMENT = "select * from channels";

	public static void sql() throws SQLException {

		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

		int count = resultSetMetaData.getColumnCount();

		for (int x = 1; x < count; x++) {
			System.out.format("%20s", resultSetMetaData.getColumnName(x) + " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int z = 1; z < count; z++) {
					System.out.format("%20s", resultSetMetaData.getColumnName(z) + " | ");
				}

				if (statement != null)
					statement.close();
				if (statement != null)
					connection.close();
			}
		}
	}

}
