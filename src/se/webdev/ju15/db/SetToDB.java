package se.webdev.ju15.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//id, name, date, röstningar,inlägg

import se.webdev.ju15.bean.DataBean;

public class SetToDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:c:/Users/joaki/Desktop/Front-End/WebdevDB:create=true;user=webdev;password=web";
	public static final String SQL_STATEMENT = "select * from channels";
	
	public void writeBean(DataBean db) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(JDBC_URL);
			con.createStatement().execute("insert into STORIES values"
					+ "('"+db.getId()+"',"
					+ "'"+db.getName()+"',"
					+ "'"+db.getDate()+"',"
					+ "'"+db.getVotes()+"',"
					+ "'"+db.getMessage()+"')"
					);
		}
		catch(ClassNotFoundException e){e.printStackTrace();}
		finally{
			try{
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(Exception e){}
		}
	}
}