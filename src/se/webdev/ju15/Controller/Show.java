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
import se.webdev.ju15.bean.DataBean;
import se.webdev.ju15.sort.SortFunctions;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
	ArrayList<DataBean> list;
	ArrayList<DataBean> highList;	
	GetFromDB gdb = new GetFromDB();
	SortFunctions sort = new SortFunctions();
	HttpSession session = req.getSession();
	
	
		try {
			list = gdb.getDataFromDb();
			sort.random(list);
			highList = sort.highestRating(list);
			session.setAttribute("list", list);
			session.setAttribute("highList", highList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
}