package se.webdev.ju15.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmbeddedDerbyDataBase
 */
@WebServlet("/EmbeddedDerbyDataBase")
public class EmbeddedDerbyDataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:c:/Users/joaki/Desktop/Front-End/WebdevDB:create=true;user=webdev;password=web";
	public static final String SQL_STATEMENT = "select * from channels";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Connection connection = null;
		Statement statement = null;
		pw.println("<html><head></head><body><table width=30%><tr>");
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(JDBC_URL);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
			ResultSetMetaData rsMeta = resultSet.getMetaData();
			int columntCount = rsMeta.getColumnCount();
			
			for (int x = 1; x <= columntCount; x++) {
				pw.println("<td bgcolor=lightblue>" + rsMeta.getColumnName(x).toString() + "</td>");
				pw.println(resultSet.getString(x));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

		}finally{
			try{
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				
			}
		}

		pw.println("</tr>");
		pw.println("</table></body></html>");

	}

}
