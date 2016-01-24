package se.webdev.ju15.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.webdev.ju15.db.GetFromDB;
import se.webdev.ju15.db.SetToDB;
import se.webdev.ju15.model.DataBean;
import se.webdev.ju15.sort.SortFunctions;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = "/index.jsp";
		ArrayList<DataBean> entireList = new ArrayList<DataBean>();
		ArrayList<DataBean> highList = new ArrayList<DataBean>();
		ArrayList<DataBean> randomList = new ArrayList<DataBean>();
		ArrayList<DataBean> newList = new ArrayList<DataBean>();
		GetFromDB gdb = new GetFromDB();
		SortFunctions sort = new SortFunctions();
		HttpSession session = req.getSession();
		
		
		try {
			entireList = gdb.getDataFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		highList = sort.newPosts(entireList);
		randomList = sort.random(entireList);
		newList = sort.newPosts(entireList);
		
	
		session.setAttribute("randomList", randomList);
		session.setAttribute("highList", highList);
		session.setAttribute("newList", newList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
}
