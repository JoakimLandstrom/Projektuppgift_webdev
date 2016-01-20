package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetFromDB {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:/Users/daniel/Documents/java/gitProjects/Projektuppgift_webdev/DB/TravelDB;create=true;";
	public static final String SQL_STATEMENT = "select * from Stories";
	
	public void getDataFromDb() throws SQLException{
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(SQL_STATEMENT);
			ResultSetMetaData rsMeta = resultSet.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			int rowCounter=0;
			while(resultSet.next()){
				System.out.print("Row: "+rowCounter);
				for(int x=1; x<=columnCount; x++){
					System.out.print(" "+resultSet.getString(x));
				}
				System.out.println();
				rowCounter++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(stmt!=null){stmt.close();}
			}catch(Exception e){}
		}
	}
}