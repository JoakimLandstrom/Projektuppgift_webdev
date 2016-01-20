package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.webdev.ju15.bean.DataBean;
import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;

public class Controller extends HttpServlet {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean(1, name, com, "12/12/12", 99);
		try {
			sdb.writeBean(nb);
			gdb.getDataFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
}
