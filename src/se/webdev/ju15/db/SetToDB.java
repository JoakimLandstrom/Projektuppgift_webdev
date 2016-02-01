package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//id, name, date, röstningar,inlägg

import se.webdev.ju15.bean.DataBean;

/**
 * 
 * @author Joakim and Daniel
 *
 */

public class SetToDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:C:/Users/joaki/Desktop/Front-End/Projektuppgift_webdev/DB/TravelDb;create=true";
	public static final String SQL_STATEMENT = "select * from message";

	public void writeBean(DataBean db) throws SQLException {
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
		
			con.createStatement().execute("insert into message(TITLE, MESSAGE, LOCATION, VOTES) values ('" + db.getName() + "','" +  db.getMessage() +"', '" + db.getLocation() +"', '"+ db.getVotes()+"')");
			System.out.println("Does it work?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void updateDb(DataBean bean)throws SQLException{
		
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName(DRIVER);
			con  = DriverManager.getConnection(JDBC_URL);
			con.createStatement().executeUpdate("UPDATE message SET votes='"+bean.getVotes()+"'WHERE id = " + bean.getId());
		}catch(ClassNotFoundException n){
			
		}finally{
			try{
				if(stmt != null)
					stmt.close();
				if(con != null)con.close();
			}catch(Exception e){
				
			}
		}
	}
	
	public void deleteFromDb(DataBean bean)throws SQLException{
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName(DRIVER);
			con  = DriverManager.getConnection(JDBC_URL);
			con.createStatement().executeUpdate("DELETE FROM message WHERE id = " + bean.getId());
		}catch(ClassNotFoundException n){
			
		}finally{
			try{
				if(stmt != null)
					stmt.close();
				if(con != null)con.close();
			}catch(Exception e){
				
			}
		}
		
	}
}