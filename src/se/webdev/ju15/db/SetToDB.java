package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//id, name, date, röstningar,inlägg

import se.webdev.ju15.model.DataBean;

public class SetToDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:/Users/daniel/Documents/Java/gitProjects/Projektuppgift_webdev/DB/TravelDb;create=true";
	public static final String SQL_STATEMENT = "select * from message";

	public void writeBean(DataBean db) throws SQLException {
		System.out.println("Connected to db");
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
			System.out.println("writing to the db");
			PreparedStatement ps = con.prepareStatement(
					"insert into stories(NAME, MESSAGE, LOC, VOTES) values(?,?,?,?)");
			ps.setString(1, db.getName());
			ps.setString(2, db.getMessage());
			ps.setString(3, db.getLocation());
			ps.setInt(4, db.getVotes());
			ps.executeUpdate();
				
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
		System.out.println("Updating database " + bean.getId());
		
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
}