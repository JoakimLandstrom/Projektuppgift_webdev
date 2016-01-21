package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;
import se.webdev.ju15.model.DataBean;

public class CommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String name = req.getParameter("name");
		String com = req.getParameter("comment");
		SetToDB sdb = new SetToDB();
		GetFromDB gdb = new GetFromDB();
		DataBean nb = new DataBean(1, name, com, 0);
		
		
		try {
			sdb.writeBean(nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList sortedComments = new ArrayList();
		ArrayList recentComments = new ArrayList();
		HttpSession session = req.getSession();
		session.setAttribute("sortedComments", sortedComments);
		session.setAttribute("recentComments", recentComments);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}


}
