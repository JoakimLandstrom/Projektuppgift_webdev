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
	public static final String JDBC_URL = "jdbc:derby:c:/Users/joaki/Desktop/Front-End/Projektuppgift_webdev/DB;create=true;user=webdev;password=web";
	public static final String SQL_STATEMENT = "select * from Stories";
	
	public ArrayList<DataBean> getDataFromDb() throws SQLException{
		ArrayList<DataBean> list = new ArrayList<DataBean>();
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
				DataBean db = null;
				for(int x=1; x<=columnCount; x++){
					System.out.print(" "+resultSet.getString(x));
					db = new DataBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(5));
					list.add(db);
					
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
		return list;
	}
}